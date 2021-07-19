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

import org.greenrobot.eventbus.EventBus;
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


    // TODO: 18/07/2021 see if delete 
    public static FavoriteListNeighbourFragment newInstance() {
        FavoriteListNeighbourFragment fragment = new FavoriteListNeighbourFragment();
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_favorites_list_neighbour, container, false);
        recyclerView = view.findViewById(R.id.fav_recyclerview);
        //setting recycler view adapter
        FavoritesNeighboursRecyclerViewAdapter favoritesNeighboursRecyclerViewAdapter =
                new FavoritesNeighboursRecyclerViewAdapter(getContext(), (ArrayList<Neighbour>) favList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(favoritesNeighboursRecyclerViewAdapter);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        favList.add(new Neighbour(12, "Ludovic", "https://i.pravatar.cc/150?u=a042581f3e39026702d", "Saint-Pierre-du-Mont à 5km",
                "+33 6 86 57 90 14",  "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot.."));
        //mApiService.getFavoriteNeighbours();

    }


    private void initList() {
        favList = mApiService.getFavoriteNeighbours();
        //recyclerView.setAdapter(new FavoritesNeighboursRecyclerViewAdapter(favList));
    }

    @Override
    public void onResume() {
        super.onResume();
        initList();
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    /**
     * Fired if the user clicks on a delete button
     * @param event
     */
    @Subscribe
    public void onDeleteNeighbour(DeleteNeighbourEvent event) {
        mApiService.deleteFavoriteNeighbour(event.neighbour);
        initList();
    }

}