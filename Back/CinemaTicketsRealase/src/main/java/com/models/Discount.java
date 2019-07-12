package com.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "DISCOUNT")
public class Discount {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PERCENT")
    private Double percent;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "discount")
    private List<Reservation> reservations;


    public Discount (){}



}
