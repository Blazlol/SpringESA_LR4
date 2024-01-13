package com.example.esa_lr4.jms;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import  com.example.esa_lr4.model.LogEvent;
import  com.example.esa_lr4.repository.LogEventRepo;


@Component
@RequiredArgsConstructor
public class ConsumerLog {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerLog.class);
    private final LogEventRepo logEventRepo;

    @RabbitListener(queues = {"${rabbitmq.queue.log}"})
    public void consume(LogEvent logEvent){
        LOGGER.info(String.format("message received :: %s", logEvent.getEventType()));
        logEventRepo.save(logEvent);
    }
}