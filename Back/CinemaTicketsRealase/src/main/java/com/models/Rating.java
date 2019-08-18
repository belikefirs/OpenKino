package com.models;

import com.fasterxml.jackson.annotation.*;
import com.view.Views;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "RATING")
public class Rating {
    @JsonView(Views.Internal.class)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @JsonView(Views.Internal.class)
    @Column(name = "RATING")
    private Double rating;

    @JsonView(Views.Internal.class)
    @Column(name = "COL_USER")
    private Long colUser;

    @JsonView(Views.Internal.class)
    @Column(name = "SUM_RATING")
    private Double sumRating;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rating")
    private List<Film> films;


    public Rating(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public Long getColUser() {
        return colUser;
    }

    public void setColUser(Long colUser) {
        this.colUser = colUser;
    }

    public Double getSumRating() {
        return sumRating;
    }

    public void setSumRating(Double sumRating) {
        this.sumRating = sumRating;
    }
}

//package com.models;
//
//import com.fasterxml.jackson.annotation.*;
//import com.view.Views;
//
//import javax.persistence.*;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Entity
//@Table(name = "RATING")
//public class Rating {
//    @JsonView(Views.Internal.class)
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "ID")
//    private Long id;
//
//    @Column(name = "RATING")
//    private Double rating;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rating")
//    @Column(name = "ID_KinoUser")
//    private KinoUser kinoUser;
//    @Column(name = "Ratting_KinoUser")
//    private Double kinouser_rating;
//
////    @ElementCollection
////    @CollectionTable(name="User_RATING")
////    @MapKeyJoinColumn (name = "User_ID" )
////    @Column(name = "RATING")
////    private Map<Integer, Double> rating;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rating")
//    @Column(name = "ID_Film")
//    private List<Film> films;
//
//    public Rating(){}
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
////    public Map<Integer, Double> getRating() {
////        return rating;
////    }
//
////    public void setRating(Map<Integer, Double> rating) {
////        this.rating = rating;
////    }
//
//
//    public Double getRating() {
//        return rating;
//    }
//
//    public void setRating(Double rating) {
//        this.rating = rating;
//    }
//
//    public List<Film> getFilms() {
//        return films;
//    }
//
//    public void setFilms(List<Film> films) {
//        this.films = films;
//    }
//}