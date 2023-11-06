package com.sobczyk.fraud;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudController {

    private FraudCheckHisotryService fraudCheckHisotryService;

    @GetMapping("/test/{id}")
    public String test(@PathVariable("id") Integer id) {
        return "test passed with id = " + id;
    }

    @GetMapping(path="{investorId}")
    public FraudCheckResponse isFraudster(@PathVariable("investorId") Integer investorId) {
        Boolean isFraudster = fraudCheckHisotryService.isFraudulentUser(investorId);
        log.info("fraud check request for {}", investorId);
        return new FraudCheckResponse(isFraudster);
    }
}
