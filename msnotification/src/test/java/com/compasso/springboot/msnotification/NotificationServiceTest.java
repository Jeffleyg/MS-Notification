package com.compasso.springboot.msnotification;


import com.compasso.springboot.msnotification.entity.Notification;
import com.compasso.springboot.msnotification.enums.Event;
import com.compasso.springboot.msnotification.repository.NotificationRepository;
import com.compasso.springboot.msnotification.service.NotificationService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NotificationServiceTest {

    @Mock
    private NotificationRepository notificationRepository;

    @InjectMocks
    private NotificationService notificationService;

    @Test
    public void testCreateNotification() {
        // Given
        String email = "test@example.com";
        Event event = Event.CREATE;

        // When
        notificationService.createNotification(email, event);

        // Then
        Mockito.verify(notificationRepository, Mockito.times(1)).save(Mockito.any(Notification.class));
    }
}