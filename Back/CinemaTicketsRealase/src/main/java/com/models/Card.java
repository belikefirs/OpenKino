package com.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.view.Views;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name = "CARD")
public class Card implements Serializable {
    private static final long serialVersionUID = 1L;


    @JsonView(Views.Internal.class)
    @Id
    private Long id;
    @JsonView(Views.Internal.class)
    @Column (name = "BALANCE")
    private BigDecimal balance;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ID_CARD")
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

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public List<Buy> getBuys() {
        return buys;
    }

    public void setBuys(List<Buy> buys) {
        this.buys = buys;
    }

    public KinoUser getKinoUser() {
        return kinoUser;
    }

    public void setKinoUser(KinoUser kinoUser) {
        this.kinoUser = kinoUser;
    }
}
