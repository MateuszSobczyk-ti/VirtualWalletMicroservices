package com.sobczyk.notification;

import com.sobczyk.clients.notification.NotificationRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public record NotificationService(NotificationRepository notificationRepository) {

    public void sendNotification(NotificationRequest notificationRequest) {
        notificationRepository.save(Notification.builder()
                        .message("Hi " + notificationRequest.getFirstName() + ", welcome in my web.")
                        .sender(notificationRequest.getSender())
                        .sendAt(LocalDateTime.now())
                        .toCustomerEmail(notificationRequest.getToCustomerEmail())
                        .toCustomerId(notificationRequest.getToCustomerId())
                .build());
    }
}
