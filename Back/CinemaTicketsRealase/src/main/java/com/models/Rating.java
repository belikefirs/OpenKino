package com.models;

import com.fasterxml.jackson.annotation.*;
import com.view.Views;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "RATING")
public class Rating {
    @JsonView(Views.Internal.class)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @JsonView(Views.Internal.class)
    @Column(name = "RATING")
    private Double rating;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rating")
    private List<Film> films;
    public Rating(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}