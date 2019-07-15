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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
