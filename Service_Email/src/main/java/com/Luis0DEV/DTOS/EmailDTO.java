package com.Luis0DEV.DTOS;


import com.Luis0DEV.Model.tb_eml_email;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import lombok.Data;

import org.springframework.beans.BeanUtils;


@Data
public class EmailDTO {

    @NotBlank
    private String eml_n_owner;
    @NotBlank
    @Email
    private String eml_n_from;
    @NotBlank
    @Email
    private String eml_n_to;
    @NotBlank
    private String eml_n_subject;
    @NotBlank
    private String eml_n_text;

    public tb_eml_email convertToEmailModel(){
        var emlEmail = new tb_eml_email();
        BeanUtils.copyProperties(this, emlEmail);
        return emlEmail;
    }
}
