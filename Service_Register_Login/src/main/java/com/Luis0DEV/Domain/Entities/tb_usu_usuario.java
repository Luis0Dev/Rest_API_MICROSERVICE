package com.Luis0DEV.Domain.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
public class tb_usu_usuario {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    public UUID usu_n_codigo;

    @JsonProperty("Usuário")
    @NotNull(message = "Usuário é obrigatório")
    @NotEmpty(message = "Usuário é obrigatório")
    @Size(max = 100, message = "O tamanho máximo do usuário é {max}")
    private String usu_c_nome;

    @JsonProperty("Senha")
    @NotNull(message = "Senha é obrigatória")
    @NotEmpty(message = "Senha é obrigatória")
    @Size(max = 100, message = "O tamanho máximo da senha é {max}")
    private String usu_c_senha;

}
