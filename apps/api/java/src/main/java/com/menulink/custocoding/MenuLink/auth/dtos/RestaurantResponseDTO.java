package com.menulink.custocoding.MenuLink.auth.dtos;

public record RestaurantResponseDTO(
        String id,
        String name,
        String phonenumber,
        String email,
        String nuit,
        Long ownerId,
        String ownerName
        /*String adressId,*/


) {
}
