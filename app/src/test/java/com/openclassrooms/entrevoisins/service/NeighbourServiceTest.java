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
import static org.junit.Assert.assertTrue;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private NeighbourApiService service;

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
        service.favoriteStatus(1);
        List<Neighbour> neighbours = service.getFavoriteNeighbours();
        List<Neighbour> expectedNeighbours = DI.getNeighbourApiService().getFavoriteNeighbours();
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }


    @Test
    public void deleteFavoriteNeighbourWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        Neighbour deleteFavorite = neighbours.get(1);
        deleteFavorite.setFavoriteNeighbour(true);
        service.deleteNeighbour(deleteFavorite);
        assertFalse(service.getFavoriteNeighbours().contains(deleteFavorite));
    }

    @Test
    public void createNewNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        Neighbour stephane = new Neighbour(13, "Stephane", "https://i.pravatar.cc/150?u=a042581f4e29026704c", "Saint-Pierre-du-Mont à 5km",
                "+33 6 86 57 90 14",  "Bonjour !Je souhaiterais faire de la marche nordique. Pas initiée, je recherche une ou plusieurs personnes susceptibles de m'accompagner !J'aime les jeux de cartes tels la belote et le tarot..");
        service.createNeighbour(stephane);
        assertTrue(neighbours.contains(stephane));
    }
}
