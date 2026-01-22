package com.menulink.menulink_auth_service.domain.restaurant;

import com.menulink.menulink_auth_service.domain.user.UserRestaurant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String menuLink;

    @Column(nullable = false)
    private Boolean active;

    @OneToMany(mappedBy = "restaurant")
    private Set<UserRestaurant> users;
}

