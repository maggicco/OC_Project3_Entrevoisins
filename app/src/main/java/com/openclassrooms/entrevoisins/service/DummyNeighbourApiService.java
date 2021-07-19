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


    /** Get favorites
     * {@inheritDoc}
     * @return
     */

    //override get fav neighbour
    @Override
    public List<Neighbour> getFavoriteNeighbours() {

        for(int i = 0; i < neighbours.size(); i++) {
            if (neighbours.get(i).isFavoriteNeighbour()){
                favoriteNeighbours.add(neighbours.get(i));
            }
        }
        return favoriteNeighbours;
    }

    @Override
    public void favoriteStatus(long id) {

        // if neighbour id is equal favoriteNeighbour id setFavorite
//            if(neighbour.getId()==favoriteNeighbours.get)
//        }
        for(Neighbour neighbour:getNeighbours()){
            if(neighbour.getId()==id)
                neighbour.setFavoriteNeighbour(!neighbour.isFavoriteNeighbour());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    //addFavoriteNeighbour

    @Override
    public void addFavorite(Neighbour neighbour) {
        favoriteNeighbours.add(neighbour);
    }

    //override del fav neighbour
    @Override
    public void deleteFavoriteNeighbour(Neighbour neighbour) {
        favoriteNeighbours.remove(neighbour);
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
