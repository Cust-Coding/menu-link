package com.menulink.custocoding.MenuLink.auth.dtos;

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
