package com.sobczyk.fraud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckHisotryService {

    private FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public boolean isFraudulentUser(Integer userId) {
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .isFraudster(false)
                        .investorId(userId)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }

}
