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
}
