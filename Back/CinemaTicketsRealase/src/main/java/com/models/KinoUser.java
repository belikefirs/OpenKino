package com.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "KINOUSER")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class KinoUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name="ID")
    private Long id;

    @Column (name = "FNAME")
    private String fName;

    @Column (name = "LNAME")
    private String Name;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "AGE")
    private Integer age;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "MAIL")
    private String mail;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "kinoUser")
    private List<Card> cards;

    @OneToOne(optional = false)
    @JoinColumn(name="ID_IDENTIFICATION", unique = true, nullable = false, updatable = false)
    private Identification identification;


    @ManyToOne
    @JoinColumn(name = "ID_POSITION", unique = true, nullable = false, updatable = false)
    private Position position;

    public KinoUser(){}

    public Long getId() {
        return id;
    }

    public String getfName() {
        return fName;
    }

    public Integer getAge() {
        return age;
    }

    public String getMail() {
        return mail;
    }

    public String getName() {
        return Name;
    }

    public String getPhone() {
        return phone;
    }

    public List<Card> getCards() {
        return cards;
    }

    public Position getPosition() {
        return position;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setIdentification(Identification identification) {
        this.identification = identification;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Identification getIdentification() {
        return identification;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
