package com.example.school;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/school")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody School school) {
        schoolService.saveSchool(school);
    }
    @GetMapping
    public ResponseEntity<List<School>> findAll() {
        return ResponseEntity.ok(schoolService.findAll());
    }

    @GetMapping("/with-students/{schoolId}")
    public ResponseEntity<FullSchoolResponse> findStudents(@PathVariable("schoolId") Integer schoolId) {
        return ResponseEntity.ok(schoolService.findSchoolsWithStudents(schoolId));
    }
}
