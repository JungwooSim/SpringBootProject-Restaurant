package me.restaurant.Filters;

import io.jsonwebtoken.Claims;
import me.restaurant.utils.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends BasicAuthenticationFilter {

    private JwtUtil jwtUtil;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        super(authenticationManager);
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {
        Authentication authentication = getAuthentication(request);

        if (authentication != null) {
            SecurityContext context = SecurityContextHolder.getContext();
            context.setAuthentication(authentication);
        }

        chain.doFilter(request, response);
    }

    // spring 내부에서 사용하는 토큰
    private Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        if (token == null ) {
            return null;
        }
        Claims claims = jwtUtil.getClaims(token.substring("Bearer ".length())); // Token에 접두어로 "Bearer "가 붙어있어서 제거해줘야함.
        Authentication authentication = new UsernamePasswordAuthenticationToken(claims, null);

        return authentication;
    }
}
