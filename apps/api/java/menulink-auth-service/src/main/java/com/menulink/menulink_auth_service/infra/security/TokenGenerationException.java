package com.menulink.menulink_auth_service.infra.security;

public class TokenGenerationException extends RuntimeException{
    public TokenGenerationException(String message, Throwable cause) {
        super(message, cause);
    }
}
