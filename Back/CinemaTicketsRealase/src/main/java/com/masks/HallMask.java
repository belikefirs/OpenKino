package com.masks;

import com.fasterxml.jackson.annotation.JsonView;
import com.models.Hall;

import java.math.BigDecimal;

public class HallMask {
    public static class View {
        public static class Save {}
    }
    @JsonView(HallMask.View.Save.class)
    private Integer width;
    @JsonView(Hall.View.Save.class)
    private Integer height;
    @JsonView(Hall.View.Save.class)
    private Integer number;
    @JsonView(Hall.View.Save.class)
    private BigDecimal price;
    public HallMask(){}

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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
