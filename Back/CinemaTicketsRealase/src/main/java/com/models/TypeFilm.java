package com.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TYPE_FILM")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
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

    public void setId(Long id) {
        this.id = id;
    }
}
