package com.spring.scheduler.scheduler.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Referee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "referee_id")
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "referee", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Match> matches;

    public Referee() {
    }

    public Referee(String name, List<Match> matches) {
        this.name = name;
        this.matches = matches;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Match> getMatches() {
//        return matches;
//    }

//    public void setMatches(List<Match> matches) {
//        this.matches = matches;
//    }

}
