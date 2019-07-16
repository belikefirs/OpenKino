package com.models;

import javax.persistence.*;

@Entity
@Table(name = "PLACE")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name="ID")
    private Long id;

    @Column(name = "Y")
    private Integer y;

    @Column (name = "X")
    private Integer x;

    @Column (name = "PRICE")
    private Double price;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ID_RESERVATION", nullable = false)
    private Reservation reservation;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ID_HALL")
    private Hall hall;


    public Place(){}
}
