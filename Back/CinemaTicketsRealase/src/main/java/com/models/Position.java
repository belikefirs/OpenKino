package com.models;
import org.springframework.beans.factory.annotation.Autowired;

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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ID_USERKINO", unique = true, nullable = false, updatable = false)
    private KinoUser kinoUser;

    public Position(){}
}
