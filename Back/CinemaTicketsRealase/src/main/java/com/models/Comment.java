package com.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.view.Views;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Comment")
public class Comment {
    @JsonView(Views.Internal.class)
    @Id
    @GeneratedValue
    private Long id;

    @JsonView(Views.Internal.class)
    @Column(name = "Comment")
    private String comment;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonView(Views.Internal.class)
    @Column(name = "Date")
    private LocalDateTime date;


    @JsonView(Views.Internal.class)
    @ManyToOne
    @JoinColumn(name = "ID_KinoUser")
    private KinoUser kinoUser;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_Film")
    private Film film;

    @JsonView(Views.Internal.class)
    @OneToOne
    @JoinColumn(name = "ID_RatingFilmByUser")
    private RatingFilmByUser ratingFilmByUser;

    public RatingFilmByUser getRatingFilmByUser() {
        return ratingFilmByUser;
    }

    public void setRatingFilmByUser(RatingFilmByUser ratingFilmByUser) {
        this.ratingFilmByUser = ratingFilmByUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public KinoUser getKinoUser() {
        return kinoUser;
    }

    public void setKinoUser(KinoUser kinoUser) {
        this.kinoUser = kinoUser;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}
