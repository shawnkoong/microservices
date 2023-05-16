package com.shawnkoong.notificationservice.service;

import com.shawnkoong.notificationservice.event.OrderPlacedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationService {

    @KafkaListener(topics = "notificationTopic")
    public void handleNotification(OrderPlacedEvent orderPlacedEvent) {
        // send email notification
        log.info("Received notification for order {}", orderPlacedEvent.orderNumber());
    }
}
