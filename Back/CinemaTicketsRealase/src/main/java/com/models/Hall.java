package com.models;


import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Entity
@Table(name = "HALL")
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Y")
    private Integer y;

    @Column(name = "X")
    private Integer x;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "hall")
    private List<Place> places;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "hall")
    private List<Session> sessions;

    public Hall(){}

}
