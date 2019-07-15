package com.models;

import javax.naming.spi.DirObjectFactory;
import javax.persistence.*;


@Entity
@Table(name = "CARD")
public class Card {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "NUMBER")
    private Long number;

    @Column (name = "BALANCE")
    private Double balance;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ID_CARD", nullable = false)
    private KinoUser kinoUser;

    public Card(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public KinoUser getKinoUser() {
        return kinoUser;
    }

    public void setKinoUser(KinoUser kinoUser) {
        this.kinoUser = kinoUser;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }
}
