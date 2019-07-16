package com.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.lang.model.element.Name;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "FILM")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Lenght")
    private Long lenght;
    @ManyToOne
    @JoinColumn(name = "ID_LIMIT_AGE", unique = true, nullable = false, updatable = false)
    private LimitAge limitAge;

    @ManyToOne
    @JoinColumn(name = "ID_RATING", unique = true, nullable = false, updatable = false)
    private Rating rating;
    @ManyToOne
    @JoinColumn(name = "ID_TYPE_FILM")
    // @JsonManagedReference
    private TypeFilm typeFilm;

    @ManyToOne
    @JoinColumn(name = "ID_GENRE", unique = true, nullable = false, updatable = false)
    private Genre genre;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "film")
    private List<Session> sessions;

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
}
