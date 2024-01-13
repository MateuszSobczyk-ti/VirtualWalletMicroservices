package com.sobczyk.investor;

import com.sobczyk.clients.fraud.FraudCheckResponse;
import com.sobczyk.clients.fraud.FraudClient;
import com.sobczyk.clients.notification.NotificationClient;
import com.sobczyk.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InvestorService {

    private final InvestorRepository investorRepository;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;

    public void register(InvestorRegistrationRequest request) {
        Investor investor = Investor.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        investorRepository.saveAndFlush(investor);
        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(investor.getId());
        notificationClient.sendNotification(NotificationRequest.builder()
                .sender("Sobczyk")
                .toCustomerEmail(investor.getEmail())
                .firstName(investor.getFirstName())
                .toCustomerId(investor.getId())
                .build());
        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }
    }
}
