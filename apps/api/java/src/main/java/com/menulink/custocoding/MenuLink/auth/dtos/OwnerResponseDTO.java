package com.menulink.custocoding.MenuLink.auth.dtos;

public record OwnerResponseDTO(
        Long id,
        String firstname,
        String lastname,
        String email
) {
}
