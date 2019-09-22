package com.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "RatingFilmByUser")
public class RatingFilmByUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_FILM")
    private Film film;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_User")
    private KinoUser kinoUser;

    @JsonIgnore
    @Column
    private Double ratingByUser;

    @OneToOne
    private Comment comment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public KinoUser getKinoUser() {
        return kinoUser;
    }

    public void setKinoUser(KinoUser kinoUser) {
        this.kinoUser = kinoUser;
    }

    public Double getRatingByUser() {
        return ratingByUser;
    }

    public void setRatingByUser(Double ratingByUser) {
        this.ratingByUser = ratingByUser;
    }


}
