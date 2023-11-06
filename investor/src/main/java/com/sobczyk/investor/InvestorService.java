package com.sobczyk.investor;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class InvestorService {

    private final InvestorRepository investorRepository;
    private final RestTemplate restTemplate;

    public void register(InvestorRegistrationRequest request) {
        Investor investor = Investor.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        investorRepository.saveAndFlush(investor);
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud-check/" + investor.getId(),
                FraudCheckResponse.class
        );
        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }
    }
}
