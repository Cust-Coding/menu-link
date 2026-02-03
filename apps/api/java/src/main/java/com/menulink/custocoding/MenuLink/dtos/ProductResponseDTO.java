package com.menulink.custocoding.MenuLink.dtos;

import com.menulink.custocoding.MenuLink.models.ProductStock;
import com.menulink.custocoding.MenuLink.models.Restaurant;

import java.math.BigDecimal;

public record ProductResponseDTO(
        Long id,
        String name,
        String description,
        BigDecimal price,
        String restaurantId,
        String restaurantName

) {
}
