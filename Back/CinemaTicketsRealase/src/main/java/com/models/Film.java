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
    private long id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Lenght")
    private long lenght;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "film")
    private List<LimitAge> limitAges;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "film")
    private List<Rating> ratings;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "film")
    private List<TypeFilm> typeFilms;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "film")
    private List<Genre> genres;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "film")
    private List<Session> sessions;
}
