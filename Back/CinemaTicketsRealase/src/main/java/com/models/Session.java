package com.models;

import com.configuration.SecurityConfig;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.view.Views;

import javax.persistence.*;


import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "Session")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

@JsonSerialize(using = SecurityConfig.LocalDateTimeSerializer.class)
@JsonDeserialize(using = SecurityConfig.LocalDateTimeDeserializer.class)
    @Column(name = "START")
    private LocalDateTime start;

@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_FILM")
    private Film film;

@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_HALL")
    //// @JsonManagedReference
    private Hall hall;

    public Session(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }



    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public LocalDateTime getStart() {
        return start;
    }
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }
}
