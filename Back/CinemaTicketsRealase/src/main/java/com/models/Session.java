package com.models;

import javax.persistence.*;


import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Session")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name="ID")
    private Long id;
    @Column(name = "Name")
    private String name;

    @Column(name = "START")
    private Date start;

    @Column(name = "END")
    private Date end;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ID_FILM", nullable = false)
    private Film film;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ID_HALL", nullable = false)
    private Hall hall;

    public Session(){}
}
