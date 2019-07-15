package com.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "GENRE")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Name")
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "genre")
    private List<Film> films;

    public Genre(){}

    public void setId(Long id) {
        this.id = id;
    }
}
