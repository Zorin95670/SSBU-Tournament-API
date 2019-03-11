package com.ssbu.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.ssbu.dao.TournamentDAO;
import com.ssbu.dto.TournamentCreationDTO;
import com.ssbu.model.QueryOption;
import com.ssbu.model.Tournament;
import com.ssbu.model.exception.MissingParameterException;

@RunWith(MockitoJUnitRunner.class)
public class TournamentControllerTest {

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getTournamentsTest() {
        final TournamentController controller = new TournamentController();

        final List<Tournament> response = controller.getTournaments(new QueryOption()).getResources();

        assertNotNull(response);
        assertTrue(response.isEmpty());
    }

    @Test
    public void createTournamentTest() throws MissingParameterException {
        final TournamentDAO dao = Mockito.mock(TournamentDAO.class);
        final String name = "test";
        final Tournament expected = new Tournament(1L, name);

        Mockito.when(dao.save(new Tournament(name))).thenReturn(expected);

        final TournamentController controller = new TournamentController();

        assertEquals(expected, controller.createTournament(new TournamentCreationDTO()));
    }
}
