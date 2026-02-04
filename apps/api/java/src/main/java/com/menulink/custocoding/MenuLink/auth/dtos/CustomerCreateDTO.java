package com.menulink.custocoding.MenuLink.auth.dtos;

import com.menulink.custocoding.MenuLink.auth.enums.CustomerGender;

public record CustomerCreateDTO(
        String username,
        String phonenumber,
        CustomerGender gender
) {
}
