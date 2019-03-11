package com.ssbu.dto;

import java.util.List;

public class CompetitorCreationDTO {

    private List<String> competitors;

    public List<String> getCompetitors() {
        return this.competitors;
    }

    public void setCompetitors(final List<String> competitors) {
        this.competitors = competitors;
    }
}
