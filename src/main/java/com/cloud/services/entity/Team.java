package com.cloud.services.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "team")
public class Team implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private List<Player> players;

    public Long getId() {
        return id;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Team(List<Player> players) {
        this.players = players;
    }

    public Team() {
    }
}