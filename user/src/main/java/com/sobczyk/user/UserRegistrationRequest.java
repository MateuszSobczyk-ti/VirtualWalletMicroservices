package com.sobczyk.user;

public record UserRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}
