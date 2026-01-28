package com.menulink.custocoding.MenuLink.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String firstname;

    private String lastname;

    private String email;

    @OneToMany(mappedBy = "owner")
    private Restaurant restaurant;



}
