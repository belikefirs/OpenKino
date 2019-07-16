package com.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "LIMIT_AGE")
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
}
