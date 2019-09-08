package com.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.stereotype.Indexed;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "HALL")
public class Hall {
    public static class View{
        public static class Save{}
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "NUMBER")
    @JsonView(Hall.View.Save.class)
    private Integer number;
    @Column(name = "Width")
    @JsonView(Hall.View.Save.class)
    private Integer width;
    @Column(name = "Height")
    @JsonView(Hall.View.Save.class)
    private Integer height;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "hall")
    @JsonManagedReference
    private List<Place> places = new ArrayList<>();
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "hall")
    @JsonIgnore
    private List<Session> sessions = new ArrayList<>();
    public Hall(){}
    public Long getId() {
        return id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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
