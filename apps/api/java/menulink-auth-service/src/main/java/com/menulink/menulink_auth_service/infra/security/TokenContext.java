package com.menulink.menulink_auth_service.infra.security;

import com.menulink.menulink_auth_service.dto.TokenData;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@UtilityClass
public class TokenContext {

    public TokenData get() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return (TokenData) auth.getDetails();
    }

    public String restaurantId() {
        return get().restaurantId();
    }

    public String userId() {
        return get().userId();
    }

    public String role() {
        return get().role();
    }
}
