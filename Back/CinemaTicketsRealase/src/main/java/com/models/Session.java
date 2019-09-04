package com.models;

import com.components.SaveAllSession;
import com.configuration.SecurityConfig;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.view.Views;

import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Session")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

@JsonSerialize(using = SecurityConfig.LocalDateTimeSerializer.class)
@JsonDeserialize(using = SecurityConfig.LocalDateTimeDeserializer.class)
    @Column(name = "START")
@JsonView(SaveAllSession.View.Save.class)
    private LocalDateTime start;

    @JsonSerialize(using = SecurityConfig.LocalDateTimeSerializer.class)
    @JsonDeserialize(using = SecurityConfig.LocalDateTimeDeserializer.class)
    @JsonView(SaveAllSession.View.Save.class)
    @Column(name = "END")
    private LocalDateTime end;
//@JsonIgnore
 // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "ID_FILM")
    private Film film;
    //@JsonIgnore

    @ManyToOne
    @JoinColumn(name = "ID_HALL")
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

    //@JsonIgnore
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

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }
}
