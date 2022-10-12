package com.concessionaria.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "User")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String username, email, password;
    private LocalDateTime registrationDate;
    @Override
    public String toString() {
        return "userID"+id+" - "+"Username"+username+" - "+"Data de registro "+registrationDate.toString();
    }
    public UserModel(){};
    public UserModel(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
    public UUID getId(){
        return this.id;
    }
    public void setId(UUID id) {this.id = id;}
    @Column(name = "username", nullable = false)
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Column(name = "registration_date", nullable = false)
    public LocalDateTime getRegistrationDate(){return registrationDate;}
    public void setRegistrationDate(LocalDateTime dateTime){this.registrationDate = dateTime;}
}
