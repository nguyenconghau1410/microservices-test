package com.example.student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Student student) {
        studentService.saveStudent(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAll() {
        return ResponseEntity.ok(studentService.findAllStudents());
    }

    @GetMapping("/find-with-school/{schoolId}")
    public ResponseEntity<List<Student>> findWithSchool(@PathVariable("schoolId") Integer schoolId) {
        return ResponseEntity.ok(studentService.findStudentsBySchool(schoolId));
    }
}
