package com.nttdata.certificatedemo.dao.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int score;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    public Candidate() {}

    public Candidate(String name, int score, Date dateNaissance) {
        this.name = name;
        this.score = score;
        this.dateNaissance = dateNaissance;
    }
}
