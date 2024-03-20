package com.compasso.springboot.msnotification.entity;

import com.compasso.springboot.msnotification.enums.Event;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "notification") // Nome da coleção no MongoDB
public class Notification {
    @Id
    private String email;
    private Event event;
    private LocalDateTime date;
}
