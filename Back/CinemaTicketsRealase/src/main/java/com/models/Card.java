package com.models;

import org.codehaus.jackson.map.annotate.JsonView;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name = "CARD")
public class Card {

    @JsonView(ViewCard.Public.class)
    @Id
    private Long id;

    @JsonView(ViewCard.Public.class)
    @Column(name = "BALANCE")
    private BigDecimal balance;

    @JsonView(ViewCard.Internal.class)
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ID_CARD")
    private KinoUser kinoUser;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "card")
    private List<Buy> buys;

    public Card() {
    }

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

    public class ViewCard {
        public class Public {}
        public class Internal extends Public {}
    }
}
