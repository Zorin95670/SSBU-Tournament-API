package com.ssbu.api;

import java.util.List;

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

import com.ssbu.dto.TournamentCreationDTO;
import com.ssbu.model.QueryOption;
import com.ssbu.model.Resource;
import com.ssbu.model.Tournament;
import com.ssbu.model.exception.ControllerException;
import com.ssbu.model.exception.MissingParameterException;
import com.ssbu.service.TournamentService;

@Path("/tournament")
@Produces(MediaType.APPLICATION_JSON)
@Component
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    @GET
    public Resource<Tournament> getTournaments(@BeanParam final QueryOption queryOption) {
        final Long total = this.tournamentService.count();
        final List<Tournament> tournaments = this.tournamentService.find(queryOption);

        return new Resource<>(total, tournaments);
    }

    @GET
    @Path("/{name}")
    public Tournament getTournamentByName(@PathParam("name") final String name) throws ControllerException {
        return this.tournamentService.getTournament(name);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Tournament createTournament(final TournamentCreationDTO dto) throws ControllerException {
        if (dto.getName() == null) {
            throw new MissingParameterException("name");
        }
        final Tournament tournament = new Tournament(dto);

        return this.tournamentService.save(tournament);
    }

    @POST
    public Tournament generateTournament(@PathParam("name") final String name) throws ControllerException {
        return this.tournamentService.getTournament(name);
    }
}
