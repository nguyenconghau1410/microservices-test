package com.example.school;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class FullSchoolResponse {
    private List<Student> students;
}
