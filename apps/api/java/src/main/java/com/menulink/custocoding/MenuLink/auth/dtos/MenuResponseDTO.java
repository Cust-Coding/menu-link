package com.menulink.custocoding.MenuLink.auth.dtos;

public record MenuResponseDTO (
        Long id,
        String name,
        String description,
        String restaurantId,
        String restaurantName
){
}
