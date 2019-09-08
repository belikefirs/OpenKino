package com.models;

import com.enums.Pstatus;
import com.enums.RStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.masks.PlaceMask;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PLACE")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name="ID")
    private Long id;
    @Column(name = "Y")
    @JsonView(PlaceMask.View.Save.class)
    private Integer y;
    @Column (name = "X")
    @JsonView(PlaceMask.View.Save.class)
    private Integer x;
    @Column (name = "PRICE")
    @JsonView(PlaceMask.View.Save.class)
    private BigDecimal price;
    @Column(name = "STATUS")
    private Pstatus status;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ID_RESERVATION")
    @JsonBackReference
    private Reservation reservation;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ID_BUY")
    private Buy buy;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_HALL")

    @JsonBackReference
    private Hall hall;
    public Place(){}
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Buy getBuy() {
        return buy;
    }

    public void setBuy(Buy buy) {
        this.buy = buy;
    }
    public Pstatus getStatus() {
        return status;
    }
    public void setStatus(Pstatus status) {
        this.status = status;
    }
}
