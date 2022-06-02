package com.validaservice.connections.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        var mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        var rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter(mapper));
        return rabbitTemplate;
    }
    @Bean
    public Jackson2JsonMessageConverter converter() {
        var mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        return new Jackson2JsonMessageConverter(mapper);
    }
}
