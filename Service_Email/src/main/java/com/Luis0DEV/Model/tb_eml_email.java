package com.Luis0DEV.Model;

import com.Luis0DEV.Enums.StatusEmail;

import jakarta.persistence.*;

import lombok.Data;

import java.time.LocalDateTime;

import java.util.UUID;
@Data
@Entity
@Table(name = "tb_eml_email")
public class tb_eml_email {

    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID eml_c_codigo;

    private String eml_n_owner;
    private String eml_n_from;
    private String eml_n_to;
    private String eml_n_subject;

    @Column(columnDefinition = "TEXT")
    private String eml_n_text;

    private LocalDateTime eml_d_dataEmail;
    private StatusEmail eml_d_statusEmail;
}
