package com.Luis0DEV.Infra.EntityConfiguration;

import jakarta.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Data
@Table(name = "tb_usu_usuario")
public class config_tb_usu_usuario {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "usu_n_codigo", nullable = false, columnDefinition = "UUID")
    private UUID usu_codigo;

    @Column(name = "usu_c_usuario", nullable = false, length = 100)
    private String usu_usuario;

    @Column(name = "usu_c_senha", nullable = false, length = 100)
    private String usu_senha;
}
