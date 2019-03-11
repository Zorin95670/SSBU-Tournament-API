package com.ssbu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ssbu.dto.TournamentCreationDTO;

@Entity
@Table(name = "Tournament", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "blocked", nullable = false)
    private boolean blocked = false;

    @ManyToOne
    @JoinColumn(name = "type", referencedColumnName = "id", updatable = false)
    @Enumerated(EnumType.STRING)
    private TournamentType type;

    public Tournament() {
        this(null, null);
    }

    public Tournament(final Long id) {
        this(id, null);
    }

    public Tournament(final String name) {
        this(null, name);
    }

    public Tournament(final TournamentCreationDTO tournament) {
        this(null, tournament.getName());
        this.setType(tournament.getType());
    }

    public Tournament(final Long id, final String name) {
        this(id, name, TournamentType.AUTOMATIC);
    }

    public Tournament(final Long id, final String name, final TournamentType type) {
        this.setId(id);
        this.setName(name);
        this.setType(type);
    }

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

    @JsonIgnore
    public TournamentType getTournamentType() {
        return this.type;
    }

    public String getType() {
        return this.type.getName();
    }

    public void setType(final TournamentType type) {
        this.type = type;
    }

    public void setType(final String type) {
        this.type = TournamentType.getTournamentTypeByName(type);
    }

    public boolean isBlocked() {
        return this.blocked;
    }

    public void setBlocked(final boolean blocked) {
        this.blocked = blocked;
    }
}
