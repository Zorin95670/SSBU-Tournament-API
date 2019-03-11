package com.ssbu.api;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssbu.dao.DAO;
import com.ssbu.dto.CompetitorCreationDTO;
import com.ssbu.model.Competitor;
import com.ssbu.model.QueryOption;
import com.ssbu.model.Resource;
import com.ssbu.model.Tournament;
import com.ssbu.model.exception.ControllerException;
import com.ssbu.service.TournamentService;

@Path("/tournament/{tournament}/competitor")
@Produces(MediaType.APPLICATION_JSON)
@Component
public class CompetitorController {

    @Autowired
    private DAO<Competitor> competitorDAO;

    @Autowired
    private TournamentService tournamentService;

    @GET
    public Resource<Competitor> getCompetitors(final @PathParam("tournament") String tournamentName,
            @BeanParam final QueryOption queryOption) throws ControllerException {
        final Tournament tournament = this.tournamentService.getTournament(tournamentName);
        final Competitor competitor = new Competitor();

        competitor.setTournament(tournament.getId());

        final Long total = this.competitorDAO.count(competitor);

        final List<Competitor> competitors = this.competitorDAO.find(competitor, queryOption);

        return new Resource<>(total, competitors);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Resource<Competitor> createCompetitor(final @PathParam("tournament") String tournamentName,
            final CompetitorCreationDTO competitorDTO) throws ControllerException {
        final Tournament tournament = this.tournamentService.getTournament(tournamentName);

        final List<Competitor> competitors = competitorDTO.getCompetitors().stream().distinct().map((name) -> {
            final Competitor competitor = new Competitor();

            competitor.setName(name);
            competitor.setTournament(tournament.getId());

            return this.competitorDAO.save(competitor);
        }).collect(Collectors.toList());

        return new Resource<>(Long.valueOf(competitors.size()), competitors);
    }
}
