package com.Luis0DEV.API.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Login_Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID usu_c_codigo;

    public String usu_c_usuario;
    public String usu_c_senha;

}
