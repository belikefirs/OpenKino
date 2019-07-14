package com.models;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "POSITION")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name="ID")
    private Long id;

    @Column(name = "NAME")
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "position")
    private List<KinoUser> kinoUsers;

    public Position(){}

    public List<KinoUser> getKinoUsers() {
        return kinoUsers;
    }

    public void setKinoUsers(List<KinoUser> kinoUsers) {
        this.kinoUsers = kinoUsers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
