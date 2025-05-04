package com.example.servlet.accounts;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @Column(name="login", length=45, nullable = false, unique = true)
    private String login;
    @Column(name="password", length=45, nullable = false)
    private String password;
    @Column(name="email", length=45, nullable = false)
    private String email;

    public User() {} // это обязательный пустой конструктор для Hibernate

    public User(String login, String password, String email){
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
