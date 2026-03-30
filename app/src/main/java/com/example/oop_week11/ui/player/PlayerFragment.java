package com.example.oop_week11.ui.player;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.oop_week11.R;
import com.example.oop_week11.repository.DataProvider;
import com.example.oop_week11.repository.PlayerRepository;
import com.example.oop_week11.ui.main.SearchablePage;

/**
 * A fragment representing a list of Items.
 */
public class PlayerFragment extends Fragment implements SearchablePage {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private PlayerRepository repository;
    private PlayerRecyclerViewAdapter adapter;
    private String searchQuery = "";

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PlayerFragment() {
    }

    @SuppressWarnings("unused")
    public static PlayerFragment newInstance(int columnCount) {
        PlayerFragment fragment = new PlayerFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }

        repository = new PlayerRepository(DataProvider.createSamplePlayers());
        adapter = new PlayerRecyclerViewAdapter(repository.getAll());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_player_list, container, false);

        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(adapter);
        }
        applySearchQuery(searchQuery);
        return view;
    }

    @Override
    public void applySearchQuery(String query) {
        searchQuery = query == null ? "" : query;
        if (repository != null && adapter != null) {
            adapter.updatePlayers(repository.search(searchQuery));
        }
    }
}
