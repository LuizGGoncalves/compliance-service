package com.validaservice.consumer;

import com.validaservice.model.UsuarioDto;
import com.validaservice.service.ValidaCadastroService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastroConsumer {

    @Autowired
    ValidaCadastroService validaCadastroService;
    @Autowired
    RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "cadastro")
    public void validar(UsuarioDto usuarioDto){
        rabbitTemplate.convertAndSend("cadastroStatus",validaCadastroService.validar(usuarioDto));
    }
}
