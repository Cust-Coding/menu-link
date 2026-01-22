package com.menulink.menulink_auth_service.repository;

import com.menulink.menulink_auth_service.domain.restaurant.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, String> {

    boolean existsByMenuLink(String menuLink);
}

