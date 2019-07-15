package com.models;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "POSITION")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
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

}
