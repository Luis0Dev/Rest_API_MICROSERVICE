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
    private UUID rgs_c_codigo;

    @JsonProperty("Usuário")
    @NotNull(message = "Usuário é obrigatório")
    @NotEmpty(message = "Usuário é obrigatório")
    @Size(max = 100, message = "O tamanho máximo do usuário é {max}")
    private String rgs_c_nome;

    @JsonProperty("Email")
    @NotNull(message = "Email é obrigatório")
    @NotEmpty(message = "Email é obrigatório")
    @Size(max = 100, message = "O tamanho máximo do email é {max}")
    private String rgs_c_email;

    @JsonProperty("Senha")
    @NotNull(message = "Senha é obrigatória")
    @NotEmpty(message = "Senha é obrigatória")
    @Size(max = 100, message = "O tamanho máximo da senha é {max}")
    private String rgs_c_senha;

    @JsonProperty("Genero")
    @NotNull(message = "Gênero é obrigatório")
    @NotEmpty(message = "Gênero é obrigatório")
    @Size(max = 1, message = "O tamanho máximo do gênero é {max}")
    private boolean rgs_c_genero;

    @JsonProperty("Data de Nascimento")
    @NotNull(message = "Data de Nascimento é obrigatória")
    private LocalDate rgs_d_nascimento;

    @Lob
    @JsonProperty("Foto de Perfil")
    private String rgs_c_foto;

    private Boolean rgs_b_atividade;
    private Boolean rgs_b_admin;

}
