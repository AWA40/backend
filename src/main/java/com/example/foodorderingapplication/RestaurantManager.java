package com.example.foodorderingapplication;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Entity
@Table(name = "admin")
public class RestaurantManager {
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "username")
    private String username;
    
    @Column(name = "password")
    private String password;

    /*@Enumerated(EnumType.STRING)
    private Role role;*/

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long adminId;

    public RestaurantManager(String name, String username, String password, Long adminId) {

        this.name = name;
        this.username = username;
        this.password = password;
        //this.role = role;
        this.adminId = adminId;
    }

    public RestaurantManager() {

    }

    public Long getAdminId()
    {
        return adminId;
    }

    public void setAdminId(Long adminId)
    {
        this.adminId = adminId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    /*public Role getRole()
    {
        return role;
    }

    public void setRole(Role role)
    {
        this.role = role;
    }*/
    
}
