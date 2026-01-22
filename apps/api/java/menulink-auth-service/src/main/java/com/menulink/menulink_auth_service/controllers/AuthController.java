package com.menulink.menulink_auth_service.controllers;

import com.menulink.menulink_auth_service.dto.LoginRequest;
import com.menulink.menulink_auth_service.dto.TokenData;
import com.menulink.menulink_auth_service.dto.RegisterCustomerRequest;
import com.menulink.menulink_auth_service.dto.RegisterRestaurantAdminRequest;
import com.menulink.menulink_auth_service.domain.user.User;
import com.menulink.menulink_auth_service.domain.user.UserRestaurant;
import com.menulink.menulink_auth_service.domain.user.Role;
import com.menulink.menulink_auth_service.domain.restaurant.Restaurant;
import com.menulink.menulink_auth_service.infra.security.TokenService;
import com.menulink.menulink_auth_service.repository.UserRepository;
import com.menulink.menulink_auth_service.repository.RestaurantRepository;
import com.menulink.menulink_auth_service.repository.UserRestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;
    private final RestaurantRepository restaurantRepository;
    private final UserRestaurantRepository userRestaurantRepository;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest body) {
        User user = userRepository.findByEmail(body.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuário ou senha inválidos"));

        if (!passwordEncoder.matches(body.getPassword(), user.getPassword())) {
            throw new RuntimeException("Usuário ou senha inválidos");
        }

        UserRestaurant userRestaurant = userRestaurantRepository
                .findByUserIdAndRestaurantId(user.getId(), body.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("Usuário não tem acesso a este restaurante"));

        Map<String, String> tokens = tokenService.generateTokens(user, userRestaurant);

        return ResponseEntity.ok(tokens);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterCustomerRequest request) {
        Optional<User> existingUser = userRepository.findByEmail(request.getEmail());
        if (existingUser.isPresent()) {
            throw new RuntimeException("Usuário já existe");
        }

        Optional<Restaurant> restaurant = restaurantRepository.findById(request.getRestaurantId());
        if (restaurant.isEmpty()) {
            throw new RuntimeException("Restaurante não encontrado");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);

        UserRestaurant userRestaurant = new UserRestaurant();
        userRestaurant.setUser(user);
        userRestaurant.setRestaurant(restaurant.get());
        userRestaurant.setRole(Role.CUSTOMER);
        userRestaurant.setActive(true);
        userRestaurantRepository.save(userRestaurant);

        return ResponseEntity.ok("Usuário registrado com sucesso");
    }

    @PostMapping("/register/restaurant-admin")
    @Transactional
    public ResponseEntity<String> registerRestaurantAdmin(@RequestBody RegisterRestaurantAdminRequest request) {
        Optional<User> existingUser = userRepository.findByEmail(request.getEmail());
        if (existingUser.isPresent()) {
            throw new RuntimeException("Usuário já existe");
        }

        // Cria e salva restaurante
        Restaurant restaurant = new Restaurant();
        restaurant.setName(request.getRestaurantName());
        restaurant.setMenuLink(request.getMenuLink());
        restaurant.setActive(true);
        restaurantRepository.save(restaurant);

        // Cria e salva usuário
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);

        // Cria relacionamento UserRestaurant
        UserRestaurant userRestaurant = new UserRestaurant();
        userRestaurant.setUser(user);
        userRestaurant.setRestaurant(restaurant);
        userRestaurant.setRole(Role.RESTAURANT_ADMIN);
        userRestaurant.setActive(true);
        userRestaurant.setCreatedAt(LocalDateTime.now());
        userRestaurantRepository.save(userRestaurant);

        return ResponseEntity.ok("Administrador do restaurante registrado com sucesso");
    }

    @GetMapping("/restaurant-id")
    public ResponseEntity<String> getRestaurantId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null || !(auth.getPrincipal() instanceof TokenData tokenData)) {
            throw new RuntimeException("Token inválido ou expirado");
        }

        String restaurantId = tokenData.getRestaurantId();
        return ResponseEntity.ok(restaurantId);
    }

    public RestaurantRepository getRestaurantRepository() {
        return restaurantRepository;
    }

    public UserRestaurantRepository getUserRestaurantRepository() {
        return userRestaurantRepository;
    }
}
