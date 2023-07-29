package com.sobczyk.user;

import org.springframework.stereotype.Service;

@Service
public record UserService(UserRepository userRepository) {
    public void register(UserRegistrationRequest request) {
        User user = User.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        userRepository.save(user);
    }
}
