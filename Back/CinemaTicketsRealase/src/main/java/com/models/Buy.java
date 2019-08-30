package com.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.view.Views;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "BUY")
public class Buy {
    @Id
    @GeneratedValue
    @JsonView(Views.Internal.class)
    private Long id;

    @JsonView(Views.Internal.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", locale = "ru_RU")
    @Column( name = "DATE")
    private LocalDateTime localDateTime = LocalDateTime.now();

    @JsonView(Views.Internal.class)
    @Column(name = "PRICE")
    private BigDecimal price;

    @JsonView(Views.Internal.class)
    @OneToOne
    @JoinColumn(name = "ID_RESERVATION")
    private Reservation reservation;

    @JsonView(Views.Internal.class)
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ID_CARD")
    private Card card;

    public Buy(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
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

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
