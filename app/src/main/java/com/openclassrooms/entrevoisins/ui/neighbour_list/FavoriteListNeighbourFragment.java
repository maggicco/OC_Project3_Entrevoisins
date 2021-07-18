package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.events.DeleteNeighbourEvent;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;


public class FavoriteListNeighbourFragment extends Fragment {

    Context mContext;
    Adapter myAdapter;
    Button buttonDelete;
    NeighbourApiService mApiService = DI.getNeighbourApiService();


    View view;
    private RecyclerView recyclerView;
    private List<Neighbour> favList;

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
                new FavoritesNeighboursRecyclerViewAdapter(getContext(), (ArrayList<Neighbour>) favList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(favoritesNeighboursRecyclerViewAdapter);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //mData = new ArrayList<>();

//        myAdapter = (Adapter) new FavoritesNeighboursRecyclerViewAdapter(getContext(), mData);
//
//        recyclerView.setAdapter((RecyclerView.Adapter) myAdapter);

//        favList = new ArrayList<FavoriteNeighbour>();
//        favList.add(new FavoriteNeighbour(1, "Julia", "1"));
//        favList.add(new FavoriteNeighbour(1, "Stef", "2"));
//        favList.add(new FavoriteNeighbour(1, "Jay", "1"));
//        favList.add(new FavoriteNeighbour(1, "Bram", "2"));


//        myAdapter = new FavoritesNeighboursRecyclerViewAdapter(mContext, favList);
//        recyclerView.setAdapter(myAdapter);
    }


    private void initList() {
        //favList = mApiService.getFavoriteNeighbours();
        //recyclerView.setAdapter(new FavoritesNeighboursRecyclerViewAdapter(favList));
    }

    /**
     * Fired if the user clicks on a delete button
     * @param event
     */
    @Subscribe
    public void onDeleteNeighbour(DeleteNeighbourEvent event) {
        //mApiService.deleteFavoriteNeighbour(event.);
        //favList.(event.neighbour);
        initList();
    }

}