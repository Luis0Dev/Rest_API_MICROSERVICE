package com.Luis0DEV.Services;

import com.Luis0DEV.Exception.CustomException;
import com.Luis0DEV.Models.tb_user_usuario;
import com.Luis0DEV.Repository.UserRepository;

import com.Luis0DEV.Security.JwtTokenProvider;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;

    public String signin(String user_c_usuario, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user_c_usuario, password));
            return jwtTokenProvider.createToken(user_c_usuario, userRepository.findByUsername(user_c_usuario).getUserUserRole());
        } catch (AuthenticationException e) {
            throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public String signup(tb_user_usuario userUsuario) {
        if (!userRepository.existsByUsername(userUsuario.getUser_c_usuario())) {
            userUsuario.setUser_c_senha(passwordEncoder.encode(userUsuario.getUser_c_senha()));
            userRepository.save(userUsuario);
            return jwtTokenProvider.createToken(userUsuario.getUser_c_usuario(), userUsuario.getUserUserRole());
        } else {
            throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public void delete(String username) {
        userRepository.deleteByUsername(username);
    }

    public tb_user_usuario search(String username) {
        tb_user_usuario userUsuario = userRepository.findByUsername(username);
        if (userUsuario == null) {
            throw new CustomException("The user doesn't exist", HttpStatus.NOT_FOUND);
        }
        return userUsuario;
    }

    public tb_user_usuario whoami(HttpServletRequest req) {
        return userRepository.findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));
    }

    public String refresh(String user_c_usuario) {
        return jwtTokenProvider.createToken(user_c_usuario, userRepository.findByUsername(user_c_usuario).getUserUserRole());
    }
}
