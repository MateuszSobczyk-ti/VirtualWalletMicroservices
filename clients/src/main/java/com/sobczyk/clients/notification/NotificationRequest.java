package com.sobczyk.clients.notification;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class NotificationRequest {

    private String sender;
    private String toCustomerEmail;
    private String firstName;
    private Integer toCustomerId;
}
