package com.compasso.springboot.msnotification.consumers;

import com.compasso.springboot.msnotification.constantes.RabbitmqConstantes;
import com.compasso.springboot.msnotification.dto.NotificationDTO;
import com.compasso.springboot.msnotification.entity.Notification;
import com.compasso.springboot.msnotification.repository.NotificationRepository;
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

    @RabbitListener(queues = RabbitmqConstantes.FILA_NOTIFICATION)
    private void consumidor(Message message){
        try {
            // Convertendo a mensagem JSON de volta para o objeto NotificationDTO
            String jsonMessage = new String(message.getBody());
            NotificationDTO notificationDTO = objectMapper.readValue(jsonMessage, NotificationDTO.class);

            // Mapeando os campos da NotificationDTO para a entidade Notification
            Notification notification = new Notification();
            notification.setEmail(notificationDTO.getEmail());
            notification.setEvent(notificationDTO.getEvent());
            notification.setDate(notificationDTO.getDate());

            // Salvando a notificação no banco de dados
            notificationRepository.save(notification);

        } catch (Exception e) {
            // Lidar com erros de desserialização ou de salvamento no banco de dados
            e.printStackTrace();
        }
    }

}
