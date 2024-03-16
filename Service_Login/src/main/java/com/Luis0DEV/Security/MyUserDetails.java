package com.Luis0DEV.Security;

import com.Luis0DEV.Models.tb_user_usuario;
import com.Luis0DEV.Repository.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetails implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetails loadUserByUsername(String user_c_usuario) throws UsernameNotFoundException {

        final tb_user_usuario userUsuario =  userRepository.findByUsername(user_c_usuario);

        if (userUsuario == null) {
            throw new UsernameNotFoundException("User '" + user_c_usuario + "' not found");
        }
        return org.springframework.security.core.userdetails.User
                .withUsername(user_c_usuario)
                .password(userUsuario.getUser_c_senha())
                .authorities(userUsuario.getUserUserRole())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}
