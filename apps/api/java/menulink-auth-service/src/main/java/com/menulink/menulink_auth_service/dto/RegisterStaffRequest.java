package com.menulink.menulink_auth_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterStaffRequest {
    private String email;
    private String username;
}

