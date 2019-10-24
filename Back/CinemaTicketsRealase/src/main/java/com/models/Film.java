package com.models;


import com.fasterxml.jackson.annotation.*;
import com.view.Views;
import lombok.Data;
import org.springframework.security.core.parameters.P;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "FILM")
@Data
public class Film {
    public static class View{
        public static class Public{}
        public static class Internal extends Public{}
    }
    @JsonView(View.Public.class)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonView(View.Public.class)
    @Column(name = "Name")
    private String name;

    @JsonView(View.Public.class)
    @Column(name = "Description")
    private String description;

    @JsonView(View.Public.class)
    @Column(name = "Lenght")
    private Long lenght;
    @JsonView(View.Public.class)
    @ManyToOne
    @JoinColumn(name = "ID_LIMIT_AGE")
    private LimitAge limitAge;

    @JsonView(View.Public.class)
    @ManyToOne
    @JoinColumn(name = "ID_RATING")
    private Rating rating;

    @JsonView(View.Public.class)
    @ManyToOne
    @JoinColumn(name = "ID_TYPE_FILM")
    private TypeFilm typeFilm;
    @JsonView(View.Public.class)
    @ManyToOne
    @JoinColumn(name = "ID_GENRE")
    private Genre genre;

    @JsonView({View.Internal.class, Session.View.Internal.class})
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "film")
    private List<Session> sessions;

    @JsonView(View.Internal.class)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "film")
    private List<RatingFilmByUser> ratingFilmByUsers;

    @JsonView(View.Internal.class)
    @OneToOne
    @JoinColumn(name = "ID_IMAGE")
    private Image image;

    @JsonView(View.Internal.class)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "film")
    private List<Comment> comments;



    public Film() {
    }


}
