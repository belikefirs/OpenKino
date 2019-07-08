package com.models;

import javax.persistence.*;

@Entity
@Table(name = "IDENTIFICATION")
public class Identification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @OneToOne(optional = false,mappedBy = "identification")
    private KinoUser kinoUser;

    public Identification(){}

}
