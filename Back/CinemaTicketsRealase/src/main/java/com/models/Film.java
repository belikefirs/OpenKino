package com.models;

import javax.lang.model.element.Name;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "FILM")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
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
    @JoinColumn(name = "ID_TYPE_FILM", unique = true, nullable = false, updatable = false)
    private TypeFilm typeFilm;
    @ManyToOne
    @JoinColumn(name = "ID_GENRE", unique = true, nullable = false, updatable = false)
    private Genre genre;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "film")
    private List<Session> sessions;

    public Film (){}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public void setTypeFilm(TypeFilm typeFilm) {
        this.typeFilm = typeFilm;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setLenght(Long lenght) {
        this.lenght = lenght;
    }

    public void setLimitAge(LimitAge limitAge) {
        this.limitAge = limitAge;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public LimitAge getLimitAge() {
        return limitAge;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public Genre getGenre() {
        return genre;
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

    public Rating getRating() {
        return rating;
    }

    public TypeFilm getTypeFilm() {
        return typeFilm;
    }

}
