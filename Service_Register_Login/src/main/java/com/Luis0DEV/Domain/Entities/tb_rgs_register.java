package com.Luis0DEV.Domain.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
public class tb_rgs_register
{
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    public UUID rgs_n_codigo;

    public String rgs_c_nome;
    public String rgs_c_email;
    public String rgs_c_senha;
    public String rgs_c_cpf;
    public Byte [] rgs_c_foto;
    public Boolean rgs_c_genero;
    public Boolean rgs_b_atividade;
    public LocalDate rgs_d_nascimento;
}
