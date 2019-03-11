package com.ssbu.dao;

public enum SSBUQuery {

    /**
     * Count competitor by tournament.
     */
    COUNT_COMPETITOR("SELECT count(*) FROM Competitor WHERE tournament = :tournament"),
    /**
     * Find competitor by tournament.
     */
    FIND_COMPETITOR("SELECT c FROM Competitor c WHERE tournament = :tournament"),
    /**
     * Count tournament.
     */
    COUNT_TOURNAMENT("SELECT count(*) FROM Tournament"),
    /**
     * Find tournament.
     */
    FIND_TOURNAMENT("SELECT t FROM Tournament t"),
    /**
     * Find tournament by name.
     */
    FIND_TOURNAMENT_BY_NAME("SELECT t FROM Tournament t WHERE name = :name");

    private String query;

    private SSBUQuery(final String query) {
        this.setQuery(query);
    }

    public String getQuery() {
        return this.query;
    }

    private void setQuery(final String query) {
        this.query = query;
    }

}
