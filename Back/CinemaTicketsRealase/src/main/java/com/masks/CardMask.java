package com.masks;

import java.io.Serializable;
import java.math.BigDecimal;

public class CardMask implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private BigDecimal balance;
    private Long idKinUser;
    public CardMask(){}

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Long getIdKinUser() {
        return idKinUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdKinUser(Long idKinUser) {
        this.idKinUser = idKinUser;
    }
}
