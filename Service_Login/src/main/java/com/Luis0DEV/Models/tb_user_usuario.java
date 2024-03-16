package com.Luis0DEV.Models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Data
@Entity
public class tb_user_usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public UUID user_n_codigo;


    @Size(min = 4, max = 255, message = "Minimum username length: 4 characters")
    @Column(unique = true, nullable = false)
    public String user_c_usuario;

    @Column(unique = true, nullable = false)
    public String user_c_email;

    @Size(min = 8,  message = "Minimum password length: 8 characters")
    @Column(unique = true, nullable = false)
    public String user_c_senha;

    @ElementCollection(fetch = FetchType.EAGER)
    List<tb_user_userRole> userUserRole;

}
