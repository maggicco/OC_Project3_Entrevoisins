package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;
import java.util.function.ToDoubleBiFunction;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private NeighbourApiService service;
    private Neighbour mNeighbour;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void getNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

    @Test
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }

    @Test
    public void getFavoriteNeighboursWithSuccess() {
        //same as normal neighbour but in service getFavorite and in DI
        List<Neighbour> neighbours = service.getFavoriteNeighbours();
        List<Neighbour> expectedNeighbours = DI.getNeighbourApiService().getFavoriteNeighbours();
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

    // TODO: 21/07/2021 modify test for delete fav neighbour
//    @Test
//    public void deleteFavoriteNeighbourWithSuccess() {
//        Neighbour stephane = new Neighbour(55, "Stephane", "https://i.pravatar.cc/150?u=a042581f4e29026704a", "Saint-Pierre-du-Mont ; 5km",
//                "+33 6 86 57 90 14",  "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot..");
//        service.createNeighbour(stephane);
//        stephane.setFavoriteNeighbour(stephane.isFavoriteNeighbour());
//        stephane.isFavoriteNeighbour();
//        new DummyNeighbourApiService().favoriteStatus(mNeighbour.getId());
//        mNeighbour.setFavoriteNeighbour(mNeighbour.isFavoriteNeighbour());
//        Neighbour neighbourToDelete = service.getFavoriteNeighbours().get(55);
//        service.deleteNeighbour(neighbourToDelete);
//        assertFalse(service.getFavoriteNeighbours().contains(neighbourToDelete));
//    }
}
