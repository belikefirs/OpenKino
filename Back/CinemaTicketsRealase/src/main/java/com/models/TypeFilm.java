package com.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TYPE_FILM")
public class TypeFilm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name="ID")
    private Long id;
    @Column(name = "Name")
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "limitAge")
    private List<Film> films;
    public TypeFilm(){}
}
