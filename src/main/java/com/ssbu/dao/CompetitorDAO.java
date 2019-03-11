package com.ssbu.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ssbu.model.Competitor;
import com.ssbu.model.QueryOption;

@Repository("competitorDAO")
@Transactional
public class CompetitorDAO extends CommonDAO<Competitor> {

    public CompetitorDAO() {
        super(Competitor.class);
    }

    @Override
    public Long count(final Competitor competitor) {
        return this.count(SSBUQuery.COUNT_COMPETITOR.getQuery(), (query) -> {
            query.setParameter("tournament", competitor.getTournament());
        });
    }

    @Override
    public List<Competitor> find(final Competitor competitor, final QueryOption queryOption) {
        final String sql = String.format("%s %s", SSBUQuery.FIND_COMPETITOR.getQuery(),
                queryOption.getOrderOption(this.getType()));

        return this.find(sql, (query) -> {
            query.setMaxResults(queryOption.getLimit());
            query.setFirstResult(queryOption.getOffset() * queryOption.getLimit());
            query.setParameter("tournament", competitor.getTournament());
        });
    }

    @Override
    public Competitor find(final String name) {
        // TODO Auto-generated method stub
        return null;
    }

}
