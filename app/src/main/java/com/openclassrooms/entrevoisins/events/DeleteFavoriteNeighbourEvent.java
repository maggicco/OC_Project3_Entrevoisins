package com.openclassrooms.entrevoisins.events;

import com.openclassrooms.entrevoisins.model.FavoriteNeighbour;
import com.openclassrooms.entrevoisins.model.Neighbour;

public class DeleteFavoriteNeighbourEvent {

    /**
     * Neighbour to delete
     */
    public FavoriteNeighbour favNeighbour;

    /**
     * Constructor.
     * @param favNeighbour
     */
    public DeleteFavoriteNeighbourEvent(FavoriteNeighbour favNeighbour) {
        this.favNeighbour = favNeighbour;
    }
}
