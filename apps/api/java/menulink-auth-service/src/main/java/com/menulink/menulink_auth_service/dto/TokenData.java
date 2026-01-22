package com.menulink.menulink_auth_service.dto;

public record TokenData(
        String userId,
        String restaurantId,
        String role
) {
    public String getRestaurantId() {
        return "";
    }
}

