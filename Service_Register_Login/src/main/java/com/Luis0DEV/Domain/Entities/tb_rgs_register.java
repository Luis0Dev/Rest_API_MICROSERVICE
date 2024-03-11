package com.Luis0DEV.Domain.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


import lombok.Getter;
import lombok.Setter;


import java.time.LocalTime;
import java.util.UUID;

@Getter
@Setter
@Entity
public class tb_rgs_register
{
    @Id
    @GeneratedValue
    public UUID rgs_n_codigo;

    public String rgs_c_nome;
    public String rgs_c_email;
    public String rgs_c_senha;
    public String rgs_c_cpf_rg;
    public String rgs_c_foto;
    public String rgs_c_genero;
    public Boolean rgs_b_ativiade;
    public LocalTime rgs_d_nascimento;
}
