package com.masks;

import com.models.Buy;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class CardMask implements Serializable {
    private static final long serialVersionUID = 1L;

    BigDecimal balance;
    Long idKinUser;
    List<Buy> buyList;
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

    public void setIdKinUser(Long idKinUser) {
        this.idKinUser = idKinUser;
    }

    public List<Buy> getBuyList() {
        return buyList;
    }

    public void setBuyList(List<Buy> buyList) {
        this.buyList = buyList;
    }
}
