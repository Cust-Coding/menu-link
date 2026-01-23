package com.menulink.custocoding.MenuLink.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String phonenumber;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true,nullable = false)
    private String nuit;

    @OneToMany(
            mappedBy = "restaurant",
            cascade = CascadeType.ALL
    )
    private List<Menu> menus;


    @OneToMany(mappedBy = "restaurant")
    private List<CustomerRestaurant> customerRestaurants;



    @OneToOne
    @JoinColumn(name = "adress_id", nullable = false)
    private RestaurantAdress adress;


    @ManyToOne
    @JoinColumn(name = "owner_id",nullable = false)
    private Owner owner;






}
