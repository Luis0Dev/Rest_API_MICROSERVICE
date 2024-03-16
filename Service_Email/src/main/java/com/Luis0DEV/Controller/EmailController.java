package com.Luis0DEV.Controller;

import com.Luis0DEV.DTOS.EmailDTO;
import com.Luis0DEV.Model.tb_eml_email;
import com.Luis0DEV.Services.EmailService;

import jakarta.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
public class EmailController {

    @Autowired
    EmailService emailService;

    Logger logger = LogManager.getLogger(EmailController.class);

    @PostMapping("/emails")
    public ResponseEntity<tb_eml_email> sendingEmail(@RequestBody @Valid EmailDTO emailDTO){
        return new ResponseEntity<>(emailService.sendEmail(emailDTO.convertToEmailModel()), HttpStatus.CREATED);
    }

    @GetMapping("/emails")
    public ResponseEntity<Page<tb_eml_email>> getAllEmails(@PageableDefault(page = 0, size = 5, sort= "eml_c_codigo", direction = Sort.Direction.DESC) Pageable pageable){

        logger.trace("TRACE");
        logger.debug("DEBUG");
        logger.info("INFO");
        logger.warn("WARN");
        logger.error("ERROR");
        logger.fatal("FATAL");

        return new ResponseEntity<>(emailService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/emails/{eml_c_codigo}")
    public ResponseEntity<Object> getOnEmail(@PathVariable(value = "eml_c_codigo") UUID eml_c_codigo){
        Optional<tb_eml_email> emlEmail = emailService.findById(eml_c_codigo);
        if(!emlEmail.isPresent()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not found.");
        }
        else{
            return  ResponseEntity.status(HttpStatus.OK).body(emlEmail.get());
        }
    }
}
