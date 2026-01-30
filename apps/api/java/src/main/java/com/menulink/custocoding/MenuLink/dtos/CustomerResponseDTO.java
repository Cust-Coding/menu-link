package com.menulink.custocoding.MenuLink.dtos;

import com.menulink.custocoding.MenuLink.enums.CustomerGender;

public record CustomerResponseDTO(
        String username,
        String phonenumber,
        CustomerGender gender
) {
}
