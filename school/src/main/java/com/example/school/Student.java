package com.example.school;

import lombok.Data;

@Data
public class Student {
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private Integer schoolId;
}
