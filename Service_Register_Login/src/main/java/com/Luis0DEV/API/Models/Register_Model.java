package com.Luis0DEV.API.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Register_Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID rgs_c_codigo;

    @JsonProperty("Usuário")
    @NotNull(message = "Usuário é obrigatório")
    @NotEmpty(message = "Usuário é obrigatório")
    @Size(max = 100, message = "O tamanho máximo do usuário é {max}")
    public String rgs_c_nome;

    @JsonProperty("Email")
    @NotNull(message = "Email é obrigatório")
    @NotEmpty(message = "Email é obrigatório")
    @Size(max = 100, message = "O tamanho máximo do email é {max}")
    public String rgs_c_email;

    @JsonProperty("Senha")
    @NotNull(message = "Senha é obrigatória")
    @NotEmpty(message = "Senha é obrigatória")
    @Size(max = 100, message = "O tamanho máximo da senha é {max}")
    public String rgs_c_senha;

    @JsonProperty("CPF")
    @NotNull(message = "CPF é obrigatório")
    @NotEmpty(message = "CPF é obrigatório")
    @Size(max = 100, message = "O tamanho máximo do CPF é {max}")
    public String rgs_c_cpf;

    @JsonProperty("Genero")
    @NotNull(message = "Gênero é obrigatório")
    @NotEmpty(message = "Gênero é obrigatório")
    @Size(max = 1, message = "O tamanho máximo do gênero é {max}")
    public boolean rgs_c_genero;

    @JsonProperty("Data de Nascimento")
    @NotNull(message = "Data de Nascimento é obrigatória")
    public LocalDate rgs_d_nascimento;

    @Lob
    @JsonProperty("Foto de Perfil")
    public Byte [] rgs_c_foto;

    public Boolean rgs_b_atividade;
    public Boolean rgs_b_admin;

}
