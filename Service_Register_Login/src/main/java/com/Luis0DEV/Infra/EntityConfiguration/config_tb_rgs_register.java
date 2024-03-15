package com.Luis0DEV.Infra.EntityConfiguration;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Data
@Table(name = "tb_rgs_register")
public class config_tb_rgs_register {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "rgs_n_codigo", nullable = false, columnDefinition = "UUID")
    private UUID rgs_codigo;

    @Column(name = "rgs_c_nome", nullable = false, length = 100)
    private String rgs_nome ;

    @Column(name = "rgs_c_email", nullable = false, length = 100)
    private String rgs_email;

    @Column(name = "rgs_c_senha", nullable = false, length = 100)
    private String rgs_senha;

    @Lob
    @Column(name = "rgs_c_foto", nullable = false, length = 30)
    private String rgs_foto;

    @Column(name = "rgs_c_genero", nullable = false)
    private Boolean rgs_genero;

    @Column(name = "rgs_b_atividade", nullable = false)
    private Boolean rgs_atividade;

    @Column(name = "rgs_d_nascimento", nullable = false)
    private LocalDate rgs_nascimento;

}
