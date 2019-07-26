package com.models;

import com.fasterxml.jackson.annotation.JsonView;
import com.view.Views;
import javax.persistence.*;

@Entity(name="image")
@Table(name = "IMAGE")
public class Image {
    @JsonView(Views.Internal.class)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column
    @JsonView(Views.Internal.class)
    private String type;

    @JsonView(Views.Internal.class)
    @Column(name = "Image_array", columnDefinition = "BINARY(5000000)")
    private byte[] image_array;

    @JsonView(Views.Internal.class)
    @OneToOne
    private Film film;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getImage_array() {
        return image_array;
    }

    public void setImage_array(byte[] image_array) {
        this.image_array = image_array;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
