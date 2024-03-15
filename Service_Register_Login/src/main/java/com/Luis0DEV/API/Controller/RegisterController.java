package com.Luis0DEV.API.Controller;

import com.Luis0DEV.API.Security.TokenConfiguration;
import org.springframework.beans.factory.annotation.Autowired;


public class RegisterController {

    @Autowired
    private TokenConfiguration tokenService;
}
