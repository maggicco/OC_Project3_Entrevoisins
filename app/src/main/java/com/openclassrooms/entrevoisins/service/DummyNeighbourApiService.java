package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private final List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    /** Get favorites
     * {@inheritDoc}
     * @return favoriteNeighbour
     */
    public List<Neighbour> getFavoriteNeighbours() {

        List<Neighbour> favoriteNeighbours = new ArrayList<>();

        for(int i = 0; i < neighbours.size(); i++) {
            if (neighbours.get(i).isFavoriteNeighbour()){
                favoriteNeighbours.add(neighbours.get(i));
            }
        }
        return favoriteNeighbours;
    }

    /** Get state favorite neighbour
     * {@inheritDoc}
     * @param id
     */
    @Override
    public void favoriteStatus(long id) {
        //looping neighbours
        for(Neighbour neighbour:getNeighbours()){
            if(neighbour.getId()==id)
                neighbour.setFavoriteNeighbour(!neighbour.isFavoriteNeighbour());
        }
    }

    /**
     * {@inheritDoc}
     * @param neighbour
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
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
