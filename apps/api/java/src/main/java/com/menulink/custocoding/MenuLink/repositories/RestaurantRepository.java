package com.menulink.custocoding.MenuLink.repositories;

import com.menulink.custocoding.MenuLink.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, String> {

}
