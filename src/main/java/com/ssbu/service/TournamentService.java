package com.ssbu.service;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssbu.dao.DAO;
import com.ssbu.model.QueryOption;
import com.ssbu.model.Tournament;
import com.ssbu.model.exception.BadParameterException;
import com.ssbu.model.exception.ControllerException;

@Repository("tournamentService")
public class TournamentService {

    @Autowired
    private DAO<Tournament> tournamentDAO;

    public Long count() {
        return this.tournamentDAO.count(null);
    }

    public Tournament save(final Tournament tournament) {
        return this.tournamentDAO.save(tournament);
    }

    public List<Tournament> find(final QueryOption queryOption) {
        return this.tournamentDAO.find(null, queryOption);
    }

    public Tournament getTournament(final String name) throws ControllerException {
        try {
            return this.tournamentDAO.find(name);
        } catch (final NoResultException e) {
            throw new BadParameterException(Tournament.class, "name", name);
        }
    }
}
