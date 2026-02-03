package com.menulink.custocoding.MenuLink.dtos;

import com.menulink.custocoding.MenuLink.models.ProductStock;
import com.menulink.custocoding.MenuLink.models.Restaurant;

import java.math.BigDecimal;

public record ProductCreateDTO(
        String name,
        String description,
        BigDecimal price,
        String restaurantId

) {
}
