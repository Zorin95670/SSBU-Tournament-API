package functional.controller;

import static org.junit.Assert.assertNotNull;

import javax.ws.rs.client.Entity;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import main.java.com.ssbu.model.Tournament;

public class TournamentControllerTest extends JerseyTest {

    @Test
    public void createTournamentTest() {
        final Tournament tournament = new Tournament();
        tournament.setName("test");

        this.target("users/add").request().post(Entity.json("{ \"name\": \"test\" }"));
        assertNotNull(tournament);
    }
}
