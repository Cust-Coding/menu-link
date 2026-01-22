package com.menulink.menulink_auth_service.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRestaurantAdminRequest {

    private String username;
    private String email;
    private String password;

    private String restaurantName;
    private String menuLink;
}
