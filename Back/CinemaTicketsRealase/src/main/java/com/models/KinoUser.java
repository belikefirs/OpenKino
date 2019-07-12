package com.models;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "KINOUSER")
public class    KinoUser {

    @Id
    @GeneratedValue
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
    private List<Card> cards;

    @OneToOne()
    @JoinColumn(name="ID_IDENTIFICATION")
    private Identification identification;

    @ManyToOne
    @JoinColumn(name = "ID_POSITION")
    private Position position;

    public KinoUser(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Identification getIdentification() {
        return identification;
    }

    public void setIdentification(Identification identification) {
        this.identification = identification;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
