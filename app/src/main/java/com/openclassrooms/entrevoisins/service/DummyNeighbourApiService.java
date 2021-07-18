package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private final List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();
    private final List<Neighbour> favoriteNeighbours = new ArrayList<>();


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
     * @return
     */

    @Override
    public List<Neighbour> getFavoriteNeighbours() {
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
    public void deleteFavoriteNeighbour(Neighbour neighbour) {
        favoriteNeighbours.remove(neighbour);
    }

    @Override
    public void addFavorite(Neighbour neighbour) {
        favoriteNeighbours.add(neighbour);
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
