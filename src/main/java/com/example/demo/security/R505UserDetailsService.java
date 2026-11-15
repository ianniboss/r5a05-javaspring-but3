package com.example.demo.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class R505UserDetailsService implements UserDetailsService {

    private final Map<String, UserDetails> users = new HashMap<>();

    public R505UserDetailsService() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        UserDetails user = User.builder()
                .username("user")
                .password(encoder.encode("user123"))
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password(encoder.encode("admin123"))
                .roles("USER", "ADMIN")
                .build();

        users.put(user.getUsername(), user);
        users.put(admin.getUsername(), admin);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = users.get(username);
        if (userDetails == null) {
            throw new UsernameNotFoundException("Utilisateur non trouvé avec le nom : " + username);
        }
        return userDetails;
    }
}

