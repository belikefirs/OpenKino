package com.masks;

import java.io.Serializable;

public class BuyMask implements Serializable {
    private static final long serialVersionUID = 1L;

    private CardMask cardMask;
    private Long idReservation;

    public BuyMask() {
    }

    public CardMask getCardMask() {
        return cardMask;
    }

    public void setCardMask(CardMask cardMask) {
        this.cardMask = cardMask;
    }

    public Long getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Long idReservation) {
        this.idReservation = idReservation;
    }
}