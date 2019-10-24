package com.models;

import com.configuration.SecurityConfig;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "DISCOUNT")
@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Discount {
    public static class View{
        public static class Public{}
        public static class Internal extends Public{}
    }

    @Id
    @GeneratedValue
    private Long id;

    @JsonView(View.Public.class)
    @Column(name = "NAME")
    private String name;

    @JsonView(View.Public.class)
    @Column(name = "PERCENT")
    private BigDecimal percent;

    @JsonView(View.Public.class)
    @Column(name  = "COUNT_PLACES")
    private Integer countPlaces;

    @JsonView(View.Public.class)
    @Column(name = "AGE_USER")
    private Integer ageUser;

    @JsonSerialize(using = SecurityConfig.LocalDateTimeSerializer.class)
    @JsonDeserialize(using = SecurityConfig.LocalDateTimeDeserializer.class)
    @Column(name = "DAY_OF_BIRTHDAY_USER")
    private LocalDateTime birthdayUser;

   //@JsonView(View.Public.class)
    //@Column(name = "FILM")
   // private Film film;

    @JsonSerialize(using = SecurityConfig.LocalDateTimeSerializer.class)
    @JsonDeserialize(using = SecurityConfig.LocalDateTimeDeserializer.class)
    @Column(name = "THE_LAST_TIME_FILM_START")
    private LocalDateTime lastTimeFilmStart;

    @JsonSerialize(using = SecurityConfig.LocalDateTimeSerializer.class)
    @JsonDeserialize(using = SecurityConfig.LocalDateTimeDeserializer.class)
    @Column(name = "THE_LAST_TIME_FILM_END")
    private LocalDateTime lastTimeFilmEnd;

    @Transient
    private Long idFilm;
    public Discount (){}



}
