package com.Luis0DEV.Services;

import com.Luis0DEV.Models.tb_user_userRole;
import com.Luis0DEV.Models.tb_user_usuario;

import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
@RequiredArgsConstructor
public class JwtAuthService implements CommandLineRunner {

    final UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(JwtAuthService.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Override
    public void run(String... params) throws Exception {
        tb_user_usuario admin = new tb_user_usuario();
        admin.setUser_c_usuario("admin");
        admin.setUser_c_senha("admin");
        admin.setUser_c_email("admin@email.com");
        admin.setUserUserRole(new ArrayList<tb_user_userRole>(Arrays.asList(tb_user_userRole.ROLE_ADMIN)));

        userService.signup(admin);

        tb_user_usuario client = new tb_user_usuario();
        client.setUser_c_usuario("client");
        client.setUser_c_senha("client");
        client.setUser_c_email("client@email.com");
        client.setUserUserRole(new ArrayList<tb_user_userRole>(Arrays.asList(tb_user_userRole.ROLE_CLIENT)));

        userService.signup(client);
    }
}
