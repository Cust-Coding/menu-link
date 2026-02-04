package com.menulink.custocoding.MenuLink.auth.dtos;

import java.math.BigDecimal;

public record ProductCreateDTO(
        String name,
        String description,
        BigDecimal price,
        String restaurantId

) {
}
