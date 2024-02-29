package com.compasso.springboot.msnotification.dto;

import com.compasso.springboot.msnotification.enums.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

//@JsonDeserialize
//@JsonSerialize
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDTO implements Serializable {
    private String email;
    private Event event;
    private LocalDateTime date;
}
