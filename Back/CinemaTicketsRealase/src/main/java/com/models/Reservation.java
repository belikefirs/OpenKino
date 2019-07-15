package com.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "RESERVATION")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name="ID")
    private Long id;

    @Column (name = "START")
    private Date start;

    @Column (name = "END")
    private Date end;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ID_USERKINO", nullable = false)
    private KinoUser kinoUser;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ID_DISCOUNT", nullable = false)
    private Discount discount;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "reservation")
    private List<Place> places;







    public Reservation(){}
}
