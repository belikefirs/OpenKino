package com.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.*;


@Entity
@Table(name = "CARD")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "BALANCE")
    private String balance;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ID_CARD", nullable = false)
    private KinoUser kinoUser;

    public Card(){}
}
