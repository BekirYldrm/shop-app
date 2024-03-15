package com.pinsoft.shopapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
@Table(name="users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String email;
    private String username;
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    @JsonBackReference
    private Role role;

    public User(){
        super();
    }

    public User(String email, String username, String password) {
        super();
        this.email = email;
        this.username = username;
        this.password = password;

    }

    public int getId(){
        return id;
    }
    public Role getRole(){
        return role;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
