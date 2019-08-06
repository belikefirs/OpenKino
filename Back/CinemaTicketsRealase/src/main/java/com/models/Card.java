package com.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.view.Views;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "CARD")
public class Card {

    @JsonView(Views.Internal.class)
    @Id
    private Long id;
    @JsonView(Views.Internal.class)
    @Column (name = "BALANCE")
    private Double balance;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ID_KINOUSER")
    private KinoUser kinoUser;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "card")
    private List<Buy> buys;

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
}
