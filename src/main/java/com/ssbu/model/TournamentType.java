package com.ssbu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TournamentType")
public class TournamentType {

    public final static TournamentType AUTOMATIC = new TournamentType(1, "auto");
    public final static TournamentType MANUAL = new TournamentType(2, "manual");

    public TournamentType() {
        this(0l, null);
    }

    public TournamentType(final long id, final String name) {
        this.setId(id);
        this.setName(name);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "name", updatable = false, nullable = false, length = 255)
    private String name;

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public static TournamentType getTournamentTypeByName(final String name) {
        if (MANUAL.getName().equals(name)) {
            return MANUAL;
        }

        return AUTOMATIC;
    }
}
