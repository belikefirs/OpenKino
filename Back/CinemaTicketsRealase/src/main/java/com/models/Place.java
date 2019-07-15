package com.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.*;

@Entity
@Table(name = "PLACE")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getX() {
        return x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getY() {
        return y;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

}
