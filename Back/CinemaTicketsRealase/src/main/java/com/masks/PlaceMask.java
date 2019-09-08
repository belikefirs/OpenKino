package com.masks;

import com.enums.Pstatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.models.Place;

import java.math.BigDecimal;

public class PlaceMask  {
    public static class View{
        public static class Save{}
    }
    @JsonIgnore
    private Place place;
    @JsonView(PlaceMask.View.Save.class)
    private Integer y;
    @JsonView(PlaceMask.View.Save.class)
    private Integer x;
    @JsonView(PlaceMask.View.Save.class)
    private BigDecimal price;
    @JsonView(View.Save.class)
    private Long idR;
    @JsonView(View.Save.class)
    private Long idH;
    public PlaceMask(){}
    public void initPlace(){
        this.place = new Place();
        this.place.setY(y);
        this.place.setX(x);
        this.place.setStatus(Pstatus.IsFree);
        this.place.setPrice(price);
    }
    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Long getIdR() {
        return idR;
    }

    public void setIdR(Long idR) {
        this.idR = idR;
    }

    public Long getIdH() {
        return idH;
    }

    public void setIdH(Long idH) {
        this.idH = idH;
    }
}
