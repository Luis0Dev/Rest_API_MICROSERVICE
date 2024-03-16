package com.Luis0DEV.Repository;

import com.Luis0DEV.Models.tb_user_usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<tb_user_usuario, Integer> {

    boolean existsByUsername(String user_c_usuario);

    tb_user_usuario findByUsername(String user_c_usuario);

    @Transactional
    void deleteByUsername(String user_c_usuario);

}
