package com.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "KINOUSER")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class KinoUser implements UserDetails {

    public static class View {
        public static class Setter extends Getter {
        }

        public static class Getter {
        }
    }

    @JsonView(View.Getter.class)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @JsonView(View.Getter.class)
    @Column(name = "FNAME")
    private String fName;

    @JsonView(View.Getter.class)
    @Column(name = "LNAME")
    private String name;

    @JsonView(View.Setter.class)
    @Column(name = "PASSWORD")
    private String password;

    @JsonView(View.Getter.class)
    @Column(name = "AGE")
    private Integer age;

    @JsonView(View.Getter.class)
    @Column(name = "PHONE", unique = true)
    private String phone;

    @JsonView(View.Getter.class)
    @Column(name = "MAIL", unique = true)
    private String mail;

    @JsonView(View.Getter.class)
    @Column(name = "STATUS")
    private Boolean action;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "kinoUser")
    private List<Card> cards;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_POSITION", unique = true, nullable = false, updatable = false)
    private Position position;

    public KinoUser() {
    }

    public Long getId() {
        return id;
    }

    public String getfName() {
        return fName;
    }

    public Integer getAge() {
        return age;
    }

    public String getMail() {
        return mail;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public List<Card> getCards() {
        return cards;
    }

    public Position getPosition() {
        return position;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPosition(Position position) {
        this.position = position;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAction() {
        return action;
    }

    public void setAction(Boolean action) {
        this.action = action;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("User"));
        return authorities;
    }

    @Override
    public String getUsername() {
        return getMail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
