package com.menulink.menulink_auth_service.infra.security;

import com.menulink.menulink_auth_service.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {

    private final TokenService tokenService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String path = request.getRequestURI();

        if (path.startsWith("/auth/")) {
            filterChain.doFilter(request, response);
            return;
        }

        String header = request.getHeader("Authorization");

        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);

            try {
                tokenService.decodeToken(token).ifPresentOrElse(tokenData -> {

                    var authorities = List.of(
                            new SimpleGrantedAuthority("ROLE_" + tokenData.role())
                    );

                    var authentication = new UsernamePasswordAuthenticationToken(
                            tokenData,
                            null,
                            authorities
                    );

                    SecurityContextHolder.getContext().setAuthentication(authentication);

                }, () -> {
                    SecurityContextHolder.clearContext();
                });

            } catch (Exception e) {
                SecurityContextHolder.clearContext();
                logger.warn("Erro ao decodificar token: " + e.getMessage());
            }
        }

        filterChain.doFilter(request, response);
    }
}