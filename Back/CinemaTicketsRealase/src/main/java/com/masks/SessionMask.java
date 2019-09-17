package com.masks;

import com.configuration.SecurityConfig;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.models.Hall;
import com.models.Session;

import java.time.LocalDateTime;

@JsonAutoDetect
public class SessionMask {

    @JsonIgnore
    private Session session;
    @JsonView(SessionMask.View.Save.class)
    private Long id;
    @JsonSerialize(using = SecurityConfig.LocalDateTimeSerializer.class)
    @JsonDeserialize(using = SecurityConfig.LocalDateTimeDeserializer.class)
    @JsonView(SessionMask.View.Save.class)
    private LocalDateTime start;

    @JsonSerialize(using = SecurityConfig.LocalDateTimeSerializer.class)
    @JsonDeserialize(using = SecurityConfig.LocalDateTimeDeserializer.class)
    @JsonView(SessionMask.View.Save.class)
    private LocalDateTime end;

    @JsonView(View.Save.class)
    private Integer[] hall;
    @JsonView(View.Save.class)
    private Long film;
    public SessionMask(){}
    public Session getSession() {
        return session;
    }

    public void initSession () {

        this.session = new Session();
        if(id != null){
            this.session.setId(id);
        }
        this.session.setEnd(this.end);
        this.session.setStart(this.start);
    }

    public static class View {
        public static class Save {}
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Integer[] getHall() {
        return hall;
    }

    public void setHall(Integer[] hall) {
        this.hall = hall;
    }

    public Long getFilm() {
        return film;
    }

    public void setFilm(Long film) {
        this.film = film;
    }
}
