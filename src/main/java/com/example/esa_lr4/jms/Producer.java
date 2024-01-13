package com.example.esa_lr4.jms;


import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.example.esa_lr4.model.BaseEntity;
import com.example.esa_lr4.model.LogEvent;

import javax.persistence.Table;

@Component
@RequiredArgsConstructor
public class Producer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);
    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routing.key.mail}")
    private String routingKeyMail;

    @Value("${rabbitmq.routing.key.log}")
    private String routingKeyLog;

    public void sendMessage(BaseEntity entity, EventType eventType){
        LogEvent logEvent = LogEvent.builder()
                .eventType(eventType.name())
                .tableName(entity.getClass().getAnnotation(Table.class).name())
                .description(String.format(
                        "Object: id %s, uuid %s.",
                        entity.getUniqueId().toString(),
                        entity.getUuid().toString()))
                .build();

        rabbitTemplate.convertAndSend(exchange, routingKeyMail, logEvent);
        rabbitTemplate.convertAndSend(exchange, routingKeyLog, logEvent);
        LOGGER.info(String.format("message sent :: %s", logEvent.getEventType()));
    }
}