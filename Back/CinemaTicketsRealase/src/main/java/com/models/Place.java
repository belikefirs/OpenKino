package com.models;

import com.enums.Pstatus;
import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "PLACE")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Place implements Serializable {
    public static class View{
        public static class Public{}
        public static class Internal extends Public{}
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    @JsonView({View.Public.class, Session.View.Public.class})
    private Long id;

    @Column(name = "Y")
    @JsonView({View.Public.class, Session.View.Public.class})
    private Integer y;

    @Column(name = "X")
    @JsonView({View.Public.class, Session.View.Public.class})
    private Integer x;

    @Column(name = "PRICE")
    @JsonView(View.Public.class)
    private BigDecimal price;

    @Column(name = "STATUS")
    @JsonView({View.Public.class, Session.View.Public.class})
    private Pstatus status;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ID_RESERVATION")
    @JsonView({View.Internal.class, Session.View.Public.class})
    private Reservation reservation;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ID_BUY")
    @JsonView(View.Internal.class)
    private Buy buy;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_HALL")
    @JsonView({View.Internal.class, Session.View.Public.class})
    private Hall hall;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_SESSION")
    @JsonView({View.Internal.class, Session.View.Internal.class})
    private Session session;

    public Place() {
    }
}
