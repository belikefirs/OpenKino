package com.models;

import com.fasterxml.jackson.annotation.*;
import com.view.Views;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TYPE_FILM")
public class TypeFilm {
    @JsonView(Views.Internal.class)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonView(Views.Internal.class)
    @Column(name = "Name")
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "typeFilm")
    private List<Film> films;
    public TypeFilm(){
    }

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

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}
