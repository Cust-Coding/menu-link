package com.menulink.custocoding.MenuLink.dtos;

import com.menulink.custocoding.MenuLink.models.Restaurant;

public record MenuCreateDTO(
        String name,
        String description,
        Restaurant restaurant
) {
}
