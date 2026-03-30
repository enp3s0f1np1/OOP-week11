package com.example.oop_week11.ui.main;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.example.oop_week11.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String STATE_SEARCH_QUERY = "search_query";
    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private SearchView searchView;
    private ViewPagerAdapter viewPagerAdapter;
    private List<String> tabTitles;
    private List<String> searchHints;
    private String currentQuery = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize views
        searchView = findViewById(R.id.search_view);
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);

        // List of tab titles & icons
        tabTitles = Arrays.asList("Player", "Team", "Match");
        int[] tabIcons = {R.drawable.player, R.drawable.team, R.drawable.match};

        // Set up ViewPager2 with adapter
        viewPagerAdapter = new ViewPagerAdapter(this, tabTitles);
        viewPager.setAdapter(viewPagerAdapter);

        // Connect TabLayout with ViewPager2 using TabLayoutMediator
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            tab.setText(tabTitles.get(position));
            tab.setIcon(ContextCompat.getDrawable(this, tabIcons[position]));
        }).attach();

        // search hints
        searchHints = Arrays.asList(
                getString(R.string.search_players_hint),
                getString(R.string.search_teams_hint),
                getString(R.string.search_matches_hint)
        );

        searchView.setIconifiedByDefault(false);
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.clearFocus();

        // search query listener
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                applySearchQuery(query);
                searchView.clearFocus();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                applySearchQuery(newText);
                return true;
            }
        });

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                searchView.setQueryHint(searchHints.get(position));
                applySearchQuery(currentQuery);
            }
        });

        if (savedInstanceState != null) {
            currentQuery = savedInstanceState.getString(STATE_SEARCH_QUERY, "");
        }

        searchView.setQueryHint(searchHints.get(viewPager.getCurrentItem()));
        searchView.setQuery(currentQuery, false);
        applySearchQuery(currentQuery);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_SEARCH_QUERY, currentQuery);
    }

    private void applySearchQuery(String query) {
        currentQuery = query == null ? "" : query;
        viewPagerAdapter.getSearchablePage(viewPager.getCurrentItem()).applySearchQuery(currentQuery);
    }
}