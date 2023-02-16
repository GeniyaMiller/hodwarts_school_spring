package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentInfo(@PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.notFound().build();
        }
        Student student = studentService.findStudent(id);
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public Student createStudent (@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping
    public ResponseEntity<Student> editeStudent(@RequestBody Student student) {
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        Student foundStudent = studentService.editeStudent(student);
        return ResponseEntity.ok(foundStudent);
    }

    @DeleteMapping("{id}")
    public Student deleteStudent (@PathVariable Long id) {
        return studentService.removeStudent(id);
    }

    @GetMapping("/age")
    public ResponseEntity<List<Student>> getStudentsForAge (@RequestParam int age) {
        if (age == 0 || age < 0) {
            return ResponseEntity.ok(Collections.emptyList());
        }
        List<Student> students = studentService.getStudentsForAge(age);
        return ResponseEntity.ok(students);
    }


}

