package com.models;

import com.fasterxml.jackson.annotation.*;
import com.view.Views;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "RATING")
public class Rating {
    public static class View{
        public static class Public{}
        public static class Internal extends Public{}
    }

    @JsonView({View.Public.class, Film.View.Public.class})
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @JsonView({View.Public.class, Film.View.Public.class})
    @Column(name = "RATING")
    private Double rating;

    @JsonView(Views.Internal.class)
    @Column(name = "COL_USER")
    private Long colUser;

    @JsonView(Views.Internal.class)
    @Column(name = "SUM_RATING")
    private Double sumRating;

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

    public Long getColUser() {
        return colUser;
    }

    public void setColUser(Long colUser) {
        this.colUser = colUser;
    }

    public Double getSumRating() {
        return sumRating;
    }

    public void setSumRating(Double sumRating) {
        this.sumRating = sumRating;
    }
}
