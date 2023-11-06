package com.sobczyk.investor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/investors")
public record InvestorController(InvestorService investorService) {

    @PostMapping
    public void registerUser(@RequestBody InvestorRegistrationRequest investorRegistrationRequest) {
        log.info("new Investor registration {}", investorRegistrationRequest);
        investorService.register(investorRegistrationRequest);
    }
}
