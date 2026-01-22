package com.menulink.menulink_auth_service.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.menulink.menulink_auth_service.domain.user.User;
import com.menulink.menulink_auth_service.domain.user.UserRestaurant;
import com.menulink.menulink_auth_service.dto.TokenData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.Map;
import java.util.Optional;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;


    private static final int ACCESS_TOKEN_HOURS = 3;
    private static final int REFRESH_TOKEN_DAYS = 7;

    // Create the two heroes.
    public Map<String, String> generateTokens(User user, UserRestaurant userRestaurant) {

        String accessToken = generateToken(user, userRestaurant, ACCESS_TOKEN_HOURS, "access");
        String refreshToken = generateToken(user, userRestaurant, REFRESH_TOKEN_DAYS * 24, "refresh");

        return Map.of(
                "accessToken", accessToken,
                "refreshToken", refreshToken
        );
    }

    // protagonist chasing its destiny
    private String generateToken(
            User user,
            UserRestaurant userRestaurant,
            int hoursValid,
            String type
    ) {
        try {
            Algorithm algorithm = Algorithm.HMAC512(secret);

            return JWT.create()
                    .withIssuer("menulink_auth_service")
                    .withSubject(user.getId())
                    .withClaim("email", user.getEmail())
                    .withClaim("restaurantId", userRestaurant.getRestaurant().getId())
                    .withClaim("role", userRestaurant.getRole().name())
                    .withClaim("type", type)
                    .withExpiresAt(generateExpirationDate(hoursValid))
                    .sign(algorithm);

        } catch (JWTCreationException e) {
            throw new RuntimeException("Error generating token", e);
        }
    }


    public Optional<String> validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC512(secret);
            String subject = JWT.require(algorithm)
                    .withIssuer("menulink_auth_service")
                    .build()
                    .verify(token)
                    .getSubject();
            return Optional.of(subject);
        } catch (JWTVerificationException exception) {
            return Optional.empty();
        }
    }


    private Instant generateExpirationDate(int hoursValid) {
        ZoneId mozambiqueZone = ZoneId.of("Africa/Maputo");
        LocalDateTime expirationTime = LocalDateTime.now(mozambiqueZone).plusHours(hoursValid);
        return expirationTime.atZone(mozambiqueZone).toInstant();
    }

    public Optional<TokenData> decodeToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC512(secret);

            var decoded = JWT.require(algorithm)
                    .withIssuer("menulink_auth_service")
                    .build()
                    .verify(token);

            return Optional.of(
                    new TokenData(
                            decoded.getSubject(),
                            decoded.getClaim("restaurantId").asString(),
                            decoded.getClaim("role").asString()
                    )
            );

        } catch (JWTVerificationException e) {
            return Optional.empty();
        }
    }

}
