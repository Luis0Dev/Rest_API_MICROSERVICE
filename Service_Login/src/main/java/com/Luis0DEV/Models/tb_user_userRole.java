package com.Luis0DEV.Models;

import org.springframework.security.core.GrantedAuthority;

public enum tb_user_userRole implements GrantedAuthority {

    ROLE_ADMIN, ROLE_CLIENT;

    public  String getAuthority(){
        return name();
    }
}
