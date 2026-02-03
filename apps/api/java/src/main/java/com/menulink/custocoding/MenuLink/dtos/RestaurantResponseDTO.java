package com.menulink.custocoding.MenuLink.dtos;

import com.menulink.custocoding.MenuLink.models.RestaurantAdress;

public record RestaurantResponseDTO(
        String id,
        String name,
        String phonenumber,
        String email,
        String nuit
   /*     String adressId,
        String ownerId*/


) {
}
