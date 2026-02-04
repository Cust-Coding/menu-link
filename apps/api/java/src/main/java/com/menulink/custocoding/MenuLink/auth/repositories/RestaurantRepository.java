package com.menulink.custocoding.MenuLink.auth.repositories;

import com.menulink.custocoding.MenuLink.auth.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, String> {

}
