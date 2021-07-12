package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.events.DeleteFavoriteNeighbourEvent;
import com.openclassrooms.entrevoisins.events.DeleteNeighbourEvent;
import com.openclassrooms.entrevoisins.model.FavoriteNeighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;


public class FavoriteListNeighbourFragment extends ListFragment {

    View view;
    private NeighbourApiService mApiService;
    private RecyclerView recyclerView;
    private List<FavoriteNeighbour> favList;

    public FavoriteListNeighbourFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_favorites_list_neighbour, container, false);
        recyclerView = view.findViewById(R.id.fav_recyclerview);
        FavoritesNeighboursRecyclerViewAdapter favoritesNeighboursRecyclerViewAdapter =
                new FavoritesNeighboursRecyclerViewAdapter(getContext(), favList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(favoritesNeighboursRecyclerViewAdapter);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        favList = new ArrayList<>();
        //favList.add(new FavoriteNeighbour(1, "Julia", R.drawable.ic_launcher_foreground));
        //favList.add(new FavoriteNeighbour(1, "Julia", R.drawable.ic_launcher_foreground));

    }


    private void initList() {
        favList = mApiService.getFavoriteNeighbours();
        recyclerView.setAdapter(new FavoritesNeighboursRecyclerViewAdapter(favList));
    }

    /**
     * Fired if the user clicks on a delete button
     * @param event
     */
    @Subscribe
    public void onDeleteNeighbour(DeleteFavoriteNeighbourEvent event) {
        mApiService.deleteFavoriteNeighbour(event.favNeighbour);
        //favList.(event.neighbour);
        initList();
    }

}