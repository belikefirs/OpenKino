package com.components;

import com.configuration.SecurityConfig;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.models.Session;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.Map;

@JsonAutoDetect
public class SaveAllSession {

    @JsonIgnore
    private Session session;

    @JsonSerialize(using = SecurityConfig.LocalDateTimeSerializer.class)
    @JsonDeserialize(using = SecurityConfig.LocalDateTimeDeserializer.class)
    @JsonView(SaveAllSession.View.Save.class)
    private LocalDateTime start;

    @JsonSerialize(using = SecurityConfig.LocalDateTimeSerializer.class)
    @JsonDeserialize(using = SecurityConfig.LocalDateTimeDeserializer.class)
    @JsonView(SaveAllSession.View.Save.class)
    private LocalDateTime end;

    @JsonView(View.Save.class)
    private Long idHall;
    @JsonView(View.Save.class)
    private Long idFilm;
    public SaveAllSession(){}
    public Session getSession() {
        return session;
    }

    public void initSession () {
        this.session = new Session();
        this.session.setEnd(this.end);
        this.session.setStart(this.start);
    }

    public static class View {
        public static class Save {}
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

    public Long getIdHall() {
        return idHall;
    }

    public void setIdHall(Long idHall) {
        this.idHall = idHall;
    }

    public Long getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(Long idFilm) {
        this.idFilm = idFilm;
    }
}
