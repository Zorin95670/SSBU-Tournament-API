package com.ssbu.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ssbu.model.TournamentType;

public class TournamentTypeTest {

    @Test
    public void getTournamentTypeByNameTest() {
        assertNotNull(TournamentType.getTournamentTypeByName(null));
        assertFalse(TournamentType.getTournamentTypeByName(null).isPresent());

        final String auto = "auto";
        assertNotNull(TournamentType.getTournamentTypeByName(auto));
        assertTrue(TournamentType.getTournamentTypeByName(auto).isPresent());
        assertEquals(TournamentType.AUTOMATIC.getId(), TournamentType.getTournamentTypeByName(auto).get().getId());
    }
}
