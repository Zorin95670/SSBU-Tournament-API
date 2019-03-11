package com.ssbu.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ssbu.model.QueryOption;
import com.ssbu.model.Tournament;

@Repository("tournamentDAO")
@Transactional
public class TournamentDAO extends CommonDAO<Tournament> {

    public TournamentDAO() {
        super(Tournament.class);
    }

    @Override
    public Long count(final Tournament tournament) {
        return this.count(SSBUQuery.COUNT_TOURNAMENT.getQuery());
    }

    @Override
    public Tournament find(final String name) {
        final TypedQuery<Tournament> query = this.getEntityManager()
                .createQuery(SSBUQuery.FIND_TOURNAMENT_BY_NAME.getQuery(), Tournament.class);

        query.setParameter("name", name);

        return query.getSingleResult();
    }

    @Override
    public List<Tournament> find(final Tournament tournament, final QueryOption queryOption) {
        final String sql = String.format("%s %s", SSBUQuery.FIND_TOURNAMENT.getQuery(),
                queryOption.getOrderOption(this.getType()));

        return this.find(sql, (query) -> {
            query.setMaxResults(queryOption.getLimit());
            query.setFirstResult(queryOption.getOffset() * queryOption.getLimit());
        });
    }

}
