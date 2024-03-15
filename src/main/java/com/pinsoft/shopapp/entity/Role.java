package com.pinsoft.shopapp.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="role")
public class Role {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToMany(mappedBy = "role")
    @JsonManagedReference
    private List<User> users;

    public List<User> getUsers(){
        return users;
    }
    public void setUsers(List<User> users){
        this.users= users;
    }
    public Role(){
        super();
    }

    public Role(String name){
        super();
        this.name=name;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
