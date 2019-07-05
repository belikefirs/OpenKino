package com.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "KinoUser")
public class KinoUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "ID")
    private Long id;

    @Column (name = "FNAME")
    private String fName;

    @Column (name = "LNAME")
    private String lName;

    @Column (name = "POSITION")
    private String position;

    @Column (name = "PRIORITY")
    private String priority;

    @Column (name = "PHONE")
    private String phone;

    @Column (name = "MAIL")
    private String mail;

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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
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

    @Override
    public String toString() {
        return "KinoUser{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", position='" + position + '\'' +
                ", priority='" + priority + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KinoUser kinoUser = (KinoUser) o;
        return Objects.equals(id, kinoUser.id) &&
                Objects.equals(fName, kinoUser.fName) &&
                Objects.equals(lName, kinoUser.lName) &&
                Objects.equals(position, kinoUser.position) &&
                Objects.equals(priority, kinoUser.priority) &&
                Objects.equals(phone, kinoUser.phone) &&
                Objects.equals(mail, kinoUser.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, position, priority, phone, mail);
    }
}
