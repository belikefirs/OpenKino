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
    @ManyToOne
    @JoinColumn(name = "ID_FILM", unique = true, nullable = false, updatable = false)
    private Film film;
    public LimitAge(){}
}
