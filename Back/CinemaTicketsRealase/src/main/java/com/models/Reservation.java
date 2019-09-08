package com.models;

import com.enums.RStatus;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "RESERVATION")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Reservation {
    public static class View{
        public static class Save{}
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name="ID")
    private Long id;
    @Column (name = "START", nullable = false)
    @JsonView(Reservation.View.Save.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss")
    private LocalDateTime start;
    @Column (name = "END", nullable = false)
    @JsonView(Reservation.View.Save.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss")
    private LocalDateTime end;
    @Column(name = "STATUS", nullable = false)
    @JsonView(Reservation.View.Save.class)
    private RStatus status;
    @Column(name = "PRICE", nullable = false)
    @JsonView(Reservation.View.Save.class)
    private BigDecimal price;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonView(Reservation.View.Save.class)
    @JoinColumn(name = "ID_KINOUSER")
    private KinoUser kinoUser;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "reservation")
    @JsonManagedReference
    private List<Place> places;
    @OneToOne
    @JsonView(Reservation.View.Save.class)
    private Buy buy;

    public Reservation(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public RStatus getStatus() {
        return status;
    }

    public void setStatus(RStatus status) {
        this.status = status;
    }

    public KinoUser getKinoUser() {
        return kinoUser;
    }

    public void setKinoUser(KinoUser kinoUser) {
        this.kinoUser = kinoUser;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public Buy getBuy() {
        return buy;
    }

    public void setBuy(Buy buy) {
        this.buy = buy;
    }
}
