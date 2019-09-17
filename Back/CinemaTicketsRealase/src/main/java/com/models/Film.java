package com.models;


import com.fasterxml.jackson.annotation.*;
import com.view.Views;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "FILM")
public class Film {
    @JsonView(Views.Internal.class)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonView(Views.Internal.class)
    @Column(name = "Name")
    private String name;
    @JsonView(Views.Internal.class)
    @Column(name = "Lenght")
    private Long lenght;
    @JsonView(Views.Internal.class)
    @ManyToOne
    @JoinColumn(name = "ID_LIMIT_AGE")
    private LimitAge limitAge;

    @JsonView(Views.Internal.class)
    @ManyToOne
    @JoinColumn(name = "ID_RATING")
    private Rating rating;

    @JsonView(Views.Internal.class)
    @ManyToOne
    @JoinColumn(name = "ID_TYPE_FILM")
    private TypeFilm typeFilm;
    @JsonView(Views.Internal.class)
    @ManyToOne
    @JoinColumn(name = "ID_GENRE")
    private Genre genre;

   // @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "film")
    @JsonIgnore
   private List<Session> sessions = new ArrayList();


   @OneToMany(fetch = FetchType.LAZY, mappedBy = "film")
   @JsonIgnore
    private List<RatingFilmByUser> ratingFilmByUsers;

    @JsonView(Views.Internal.class)
    @OneToOne
    @JoinColumn(name = "ID_IMAGE")
    private Image image;

    @JsonView(Views.Internal.class)
    @Column(name = "Description")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Film (){}

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

    public Long getLenght() {
        return lenght;
    }

    public void setLenght(Long lenght) {
        this.lenght = lenght;
    }

    public LimitAge getLimitAge() {
        return limitAge;
    }

    public void setLimitAge(LimitAge limitAge) {
        this.limitAge = limitAge;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public TypeFilm getTypeFilm() {
        return typeFilm;
    }

    public void setTypeFilm(TypeFilm typeFilm) {
        this.typeFilm = typeFilm;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
