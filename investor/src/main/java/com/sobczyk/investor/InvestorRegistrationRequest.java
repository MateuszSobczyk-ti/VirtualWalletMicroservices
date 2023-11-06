package com.sobczyk.investor;

public record InvestorRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}
