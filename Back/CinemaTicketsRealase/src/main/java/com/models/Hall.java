package com.models;



import com.configuration.SecurityConfig;
import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.stereotype.Indexed;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "HALL")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Hall implements Serializable {
    public static class View{
        public static class Public{}
        public static class Internal extends Public{}
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(View.Public.class)
    private Long id;

    @Column(name = "NUMBER")
    @JsonView(View.Public.class)
    private Long number;

    @Column(name = "Width")
    @JsonView(View.Public.class)
    private Integer width;

    @Column(name = "Height")
    @JsonView(View.Public.class)
    private Integer height;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hall")
    @JsonView(View.Public.class)
    private List<Place> places;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "hall")
    @JsonView(View.Public.class)
    private List<Session> sessions = new ArrayList<>();

    public Hall(){
    }



}
