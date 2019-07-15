package com.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "LIMIT_AGE")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class LimitAge {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name="ID")
    private Long id;
    @Column(name = "Age")
    private int age;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "limitAge")
    private List<Film> films;
    public LimitAge(){}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
