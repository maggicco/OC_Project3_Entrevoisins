package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.FavoriteNeighbour;
import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;


/**
 * Neighbour API client
 */
public interface NeighbourApiService {

    /**
     * Get all my Neighbours
     * @return {@link List}
     */
    List<Neighbour> getNeighbours();

    /**
     * Deletes a neighbour
     * @param neighbour
     */
    void deleteNeighbour(Neighbour neighbour);

    /**
     * Get all my Favorite Neighbours
     * @return {@link List}
     */
    List<FavoriteNeighbour> getFavoriteNeighbours();

    //Added new  function
    /**
     * Deletes a favorite neighbour
     * @param favNeighbour
     */
    void deleteFavoriteNeighbour(FavoriteNeighbour favNeighbour);

    /**
     * Create a neighbour
     * @param neighbour
     */
    void createNeighbour(Neighbour neighbour);
}
