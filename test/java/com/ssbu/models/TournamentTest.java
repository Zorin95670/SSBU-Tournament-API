package com.ssbu.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ssbu.model.Tournament;
import com.ssbu.model.TournamentType;

public class TournamentTest {

    @Test
    public void getterAndSetterTest() {
        Tournament tournament = new Tournament();
        assertNull(tournament.getId());
        assertNull(tournament.getName());
        assertEquals(TournamentType.AUTOMATIC, tournament.getType());
        assertFalse(tournament.isBlocked());

        tournament = new Tournament(1L);
        assertEquals(Long.valueOf(1L), tournament.getId());
        assertNull(tournament.getName());
        assertEquals(TournamentType.AUTOMATIC, tournament.getType());
        assertFalse(tournament.isBlocked());

        tournament = new Tournament("test");
        assertNull(tournament.getId());
        assertEquals("test", tournament.getName());
        assertEquals(TournamentType.AUTOMATIC, tournament.getType());
        assertFalse(tournament.isBlocked());

        tournament.setType("bad");
        assertEquals(TournamentType.AUTOMATIC, tournament.getType());

        tournament.setType("manual");
        assertEquals(TournamentType.MANUAL, tournament.getType());

        tournament.setType(TournamentType.AUTOMATIC);
        assertEquals(TournamentType.AUTOMATIC, tournament.getType());

        tournament.setBlocked(true);
        assertTrue(tournament.isBlocked());
    }
}
