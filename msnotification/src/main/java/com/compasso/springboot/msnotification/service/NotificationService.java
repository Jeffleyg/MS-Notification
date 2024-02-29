package com.compasso.springboot.msnotification.service;

import com.compasso.springboot.msnotification.entity.Notification;
import com.compasso.springboot.msnotification.enums.Event;
import com.compasso.springboot.msnotification.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationService {

    @Autowired
    NotificationRepository notificationRepository;

    public void createNotification(String email, Event event) {
        Notification notification = new Notification();
        notification.setEmail(email);
        notification.setEvent(event);
        notification.setDate(LocalDateTime.now());
        notificationRepository.save(notification);
    }
}
