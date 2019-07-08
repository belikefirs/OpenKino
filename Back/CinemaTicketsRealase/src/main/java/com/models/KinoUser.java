package com.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "KINOUSER")
public class KinoUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name="ID")
    private Long id;

    @Column (name = "FNAME")
    private String fName;

    @Column (name = "LNAME")
    private String lName;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "MAIL")
    private String mail;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "kinoUser")
    private List<Card> CARDS;

    @OneToOne(optional = false)
    @JoinColumn(name="ID_IDENTIFICATION", unique = true, nullable = false, updatable = false)
    private Identification identification;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "kinoUser")
    private List<Position> POSITION;



    public KinoUser(){}

}
