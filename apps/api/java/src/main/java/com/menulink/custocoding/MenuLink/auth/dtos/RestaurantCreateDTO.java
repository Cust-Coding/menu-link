package com.menulink.custocoding.MenuLink.auth.dtos;

public record RestaurantCreateDTO(
    String name,
    String phonenumber,
    String email,
    String nuit
/*    String ownerId,
    String adressId*/
) {
}
