package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
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
    List<Neighbour> getFavoriteNeighbours();


    //Added new  function
    /**
     * Deletes a favorite neighbour
     * @param favNeighbour
     */
    void deleteFavoriteNeighbour(Neighbour favNeighbour);

    void addFavorite(Neighbour neighbour);
    /**
     * Create a neighbour
     * @param neighbour
     */
    void createNeighbour(Neighbour neighbour);
}
