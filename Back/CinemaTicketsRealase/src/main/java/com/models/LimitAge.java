package com.models;

import com.fasterxml.jackson.annotation.*;
import com.view.Views;

import javax.persistence.*;
import java.util.List;
@Entity(name="limit_age")
@Table(name = "LIMIT_AGE")
public class LimitAge {
    public static class View{
        public static class Public{}
        public static class Internal extends Public{}
    }

    @JsonView({View.Public.class, Film.View.Public.class})
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name="ID")
    private Long id;
    @JsonView({View.Public.class, Film.View.Public.class})
    @Column(name = "Age")
    private int age;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "limitAge")
    private List<Film> films;

    public LimitAge(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}
