package com.menulink.menulink_auth_service.repository;

import com.menulink.menulink_auth_service.domain.user.UserRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRestaurantRepository extends JpaRepository<UserRestaurant, String> {

    boolean existsByUserIdAndRestaurantId(String userId, String restaurantId);
    
    Optional<UserRestaurant> findByUserIdAndRestaurantId(String userId, String restaurantId);
}

