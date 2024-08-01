package com.example.school;

import com.example.school.client.StudentClient;
import com.example.school.kafka.TestProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository schoolRepository;
    private final StudentClient studentClient;
    private final TestProducer testProducer;
    public void saveSchool(School school) {
        schoolRepository.save(school);
    }

    public List<School> findAll() {
        return schoolRepository.findAll();
    }

    public FullSchoolResponse findSchoolsWithStudents(Integer schoolId) {
        var school = schoolRepository.findById(schoolId)
                .orElse(
                        School.builder().name("NOT_FOUND").build()
                );
        var students = studentClient.findAllStudentsBySchool(schoolId);
        testProducer.sendTestConfirmation(FullSchoolResponse.builder()
                .students(students)
                .build());
        return FullSchoolResponse.builder()
                .students(students)
                .build();
    }
}
