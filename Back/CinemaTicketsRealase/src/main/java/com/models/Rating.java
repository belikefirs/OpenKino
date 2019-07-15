package com.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "RATING")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;
    @Column(name = "Name")
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "limitAge")
    private List<Film> films;
    public Rating(){}

    public void setId(long id) {
        this.id = id;
    }
}
