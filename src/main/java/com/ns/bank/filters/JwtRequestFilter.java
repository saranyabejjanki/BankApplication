package com.ns.bank.filters;

import com.ns.bank.service.impl.CustomerService;
import com.ns.bank.service.impl.UserService;
import com.ns.bank.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {


    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authorizationHeader = request.getHeader("Authorization");
        String role = request.getHeader("Role");
        System.out.println("Inside Filter..");
        String email = null;
        String jwt = null;
        UserDetails userDetails = null;
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
            email = jwtUtil.extractEmail(jwt);
            System.out.println("email inside filter"+email);
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if (nonNull(role)) {
            System.out.println("inside jwtrequest..");
            if (role.equals("Customer")) {
                userDetails = customerService.loadUserByUsername(email);
            }
        } else {
            if (nonNull(email)) {
                userDetails = userService.loadUserByUsername(email);
            }
        }
        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            if (nonNull(userDetails)) {
                if (jwtUtil.validateToken(jwt, userDetails)) {
                    System.out.println("inside JWTrequestFilter" + jwtUtil.validateToken(jwt, userDetails));
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails
                            , null, userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
            }
        }
        filterChain.doFilter(request, response);
    }
}
