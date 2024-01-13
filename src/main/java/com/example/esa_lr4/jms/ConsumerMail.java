package com.example.esa_lr4.jms;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import  com.example.esa_lr4.service.MailService;
import  com.example.esa_lr4.model.LogEvent;

@Component
@RequiredArgsConstructor
public class ConsumerMail {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerMail.class);
    private final MailService mailService;

    @RabbitListener(queues = {"${rabbitmq.queue.mail}"})
    public void consume(LogEvent logEvent){
        LOGGER.info(String.format("message received :: %s", logEvent.getEventType()));
        mailService.resolve(logEvent);
    }
}