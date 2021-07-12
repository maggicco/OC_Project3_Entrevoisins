package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.FavoriteNeighbour;
import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();
    private List<FavoriteNeighbour> favoriteNeighbours;


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    // get favorites
    /**
     * {@inheritDoc}
     */
    @Override
    public List<FavoriteNeighbour> getFavoriteNeighbours() {
        return favoriteNeighbours;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    //override del fav neighbour
    @Override
    public void deleteFavoriteNeighbour(FavoriteNeighbour favNeighbour) {
        favoriteNeighbours.remove(favNeighbour);
    }

    /**
     * {@inheritDoc}
     * @param neighbour
     */
    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }
}
