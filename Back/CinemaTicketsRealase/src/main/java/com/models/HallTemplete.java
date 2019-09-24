package com.models;

import com.fasterxml.jackson.annotation.JsonView;
import javax.persistence.*;

@Entity
@Table(name = "HALL_Templete")
public class HallTemplete {
    public static class View{
        public static class Save{}
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "NUMBER")
    @JsonView(HallTemplete.View.Save.class)
    private Integer number;
    @Column(name = "Width")
    @JsonView(HallTemplete.View.Save.class)
    private Integer width;
    @Column(name = "Height")
    @JsonView(HallTemplete.View.Save.class)
    private Integer height;

    public HallTemplete(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
