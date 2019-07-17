package com.models;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "HALL")
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Width")
    private Integer width;

    @Column(name = "Height")
    private Integer height;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "hall")
    // @JsonBackReference
    private List<Place> places;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "hall")
    // @JsonBackReference
    private List<Session> sessions;

    public Hall(){}


    public Long getId() {
        return id;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public void setHeight(Integer heighgt) {
        this.height = heighgt;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }
}
