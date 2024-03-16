package com.Luis0DEV.Repositories;

import com.Luis0DEV.Model.tb_eml_email;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmailRepository extends JpaRepository<tb_eml_email, UUID> {
}
