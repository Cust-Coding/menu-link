package com.menulink.menulink_auth_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterCustomerRequest {

    private String username;
    private String email;
    private String password;

    // resolvido pelo menu_link no frontend
    private String restaurantId;
}
