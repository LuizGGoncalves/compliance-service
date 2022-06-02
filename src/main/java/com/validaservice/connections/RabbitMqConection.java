package com.validaservice.connections;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class RabbitMqConection {

    private static final String NOME_EXCHANGE = "amq.direct";

    @Autowired
    private AmqpAdmin amqpAdmin;

    @PostConstruct
    private void criaFila(){
        var filaCadasastroStatus = new Queue("cadastroStatus",true,false,false);
        var filaErrorCadastro = new Queue("filaErroCadastro",true,false,false);
        var ligacaoCadastroStatus = new Binding(filaCadasastroStatus.getName()
                , Binding.DestinationType.QUEUE,NOME_EXCHANGE, filaCadasastroStatus.getName(), null);
        var ligacaoErroCadastro = new Binding("filaErroCadastro",
                Binding.DestinationType.QUEUE, "amq.direct","filaErrorCadastro",null);

        amqpAdmin.declareQueue(filaCadasastroStatus);
        amqpAdmin.declareQueue(filaErrorCadastro);
        amqpAdmin.declareBinding(ligacaoCadastroStatus);
        amqpAdmin.declareBinding(ligacaoErroCadastro);
    }
}
