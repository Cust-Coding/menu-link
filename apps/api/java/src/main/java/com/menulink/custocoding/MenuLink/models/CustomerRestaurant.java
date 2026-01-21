package com.menulink.custocoding.MenuLink.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CustomerRestaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    //@Column()
    //private LocalDateTime first;

    //@Column()
    //private LocalDateTime last;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurants restaurants;




}
