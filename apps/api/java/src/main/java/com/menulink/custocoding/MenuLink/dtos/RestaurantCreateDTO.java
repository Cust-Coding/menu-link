package com.menulink.custocoding.MenuLink.dtos;

import com.menulink.custocoding.MenuLink.models.Owner;

public record RestaurantCreateDTO(
    String name,
    String phonenumber,
    String email,
    String nuit
/*    String ownerId,
    String adressId*/
) {
}
