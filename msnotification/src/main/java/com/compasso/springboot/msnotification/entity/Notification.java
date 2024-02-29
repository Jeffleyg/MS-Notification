package com.compasso.springboot.msnotification.entity;

import com.compasso.springboot.msnotification.enums.Event;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "notification") // Nome da coleção no MongoDB
public class Notification {
    private String email;
    private Event event;
    private LocalDateTime date;
}
