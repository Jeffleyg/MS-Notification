package com.compasso.springboot.msnotification.consumers;

import com.compasso.springboot.msnotification.constantes.RabbitmqConstantes;
import com.compasso.springboot.msnotification.dto.NotificationDTO;
import com.compasso.springboot.msnotification.entity.Notification;
import com.compasso.springboot.msnotification.repository.NotificationRepository;
import com.compasso.springboot.msnotification.service.NotificationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationConsumer {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private NotificationService notificationService;

    @RabbitListener(queues = RabbitmqConstantes.FILA_NOTIFICATION)
    private void consumidor(Message message){
        try {
            String jsonMessage = new String(message.getBody());
            NotificationDTO notificationDTO = objectMapper.readValue(jsonMessage, NotificationDTO.class);
            notificationService.createNotification(notificationDTO.getEmail(), notificationDTO.getEvent());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
