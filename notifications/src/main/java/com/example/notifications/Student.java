package com.example.notifications;

public record Student(
        Integer id,
        String firstname,
        String lastname,
        String email,
        Integer schoolId
) {
}
