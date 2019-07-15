package com.models;


import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Entity
@Table(name = "HALL")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Height")
    private Integer height;

    @Column(name = "Width")
    private Integer width;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "hall")
    private List<Place> places;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "hall")
    private List<Session> sessions;

    public Hall(){}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getHeight() {
        return height;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getWidth() {
        return width;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public List<Session> getSessions() {
        return sessions;
    }

}
