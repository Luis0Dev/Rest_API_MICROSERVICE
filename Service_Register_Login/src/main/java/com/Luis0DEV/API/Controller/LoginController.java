package com.Luis0DEV.API.Controller;

import com.Luis0DEV.API.Models.Login_Model;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid Login_Model dados){

        var UsernamePassword = new UsernamePasswordAuthenticationToken(dados.usu_c_usuario, dados.usu_c_senha);
        var auth = this.authenticationManager.authenticate(UsernamePassword);

        return ResponseEntity.ok().build();
    }
}
