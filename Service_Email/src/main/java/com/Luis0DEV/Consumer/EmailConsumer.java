package com.Luis0DEV.Consumer;

import com.Luis0DEV.DTOS.EmailDTO;
import com.Luis0DEV.Model.tb_eml_email;
import com.Luis0DEV.Services.EmailService;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    EmailService emailService;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void lister(@Payload EmailDTO emailDTO){
        tb_eml_email emlEmail = new tb_eml_email();
        BeanUtils.copyProperties(emailDTO, emlEmail);
        emailService.sendEmail(emlEmail);
        System.out.println("Email Status:" + emlEmail.getEml_d_statusEmail().toString());
    }
}
