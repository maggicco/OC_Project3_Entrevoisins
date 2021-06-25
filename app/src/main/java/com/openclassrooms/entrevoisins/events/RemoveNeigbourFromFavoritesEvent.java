package com.openclassrooms.entrevoisins.events;

import com.openclassrooms.entrevoisins.model.Neighbour;

public class RemoveNeigbourFromFavoritesEvent {

    /**
     * Neighbour to delete
     */
    public Neighbour neighbour;


    /**
     * Constructor
     * @param neighbour
     */
    public RemoveNeigbourFromFavoritesEvent(Neighbour neighbour) {
        this.neighbour = neighbour;
    }
}
