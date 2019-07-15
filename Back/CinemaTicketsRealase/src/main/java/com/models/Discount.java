package com.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "DISCOUNT")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
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
