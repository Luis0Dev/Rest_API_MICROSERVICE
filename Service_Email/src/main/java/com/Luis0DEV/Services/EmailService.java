package com.Luis0DEV.Services;

import com.Luis0DEV.Enums.StatusEmail;
import com.Luis0DEV.Model.tb_eml_email;
import com.Luis0DEV.Repositories.EmailRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmailService {

    @Autowired
    EmailRepository emailRepository;

    Logger logger = LogManager.getLogger(EmailService.class);

    @Autowired
    private JavaMailSender emailSender;

    @Transactional
    public tb_eml_email sendEmail(tb_eml_email emlEmail){
        emlEmail.setEml_d_dataEmail(LocalDateTime.now());
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emlEmail.getEml_n_from());
            message.setTo(emlEmail.getEml_n_to());
            message.setSubject(emlEmail.getEml_n_subject());
            message.setText(emlEmail.getEml_n_text());
            emailSender.send(message);

            emlEmail.setEml_d_statusEmail(StatusEmail.SENT);
            logger.info("Email sent successfully to: {} ", emlEmail.getEml_n_to());
        }
        catch (MailException e){
            emlEmail.setEml_d_statusEmail(StatusEmail.ERROR);
            logger.error("Email with error: {} ", emlEmail.toString());
            logger.error("Error {} ", e);
        }
        finally {
            logger.info("Email saved successfully emailId: {} ", emlEmail.getEml_c_codigo());
            return emailRepository.save(emlEmail);
        }
    }

    public Page<tb_eml_email> findAll(Pageable pageable){
        return emailRepository.findAll(pageable);
    }

    public Optional<tb_eml_email> findById(UUID eml_n_codigo){
        return  emailRepository.findById(eml_n_codigo);
    }
}
