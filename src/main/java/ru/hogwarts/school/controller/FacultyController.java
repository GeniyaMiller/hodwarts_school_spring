package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("faculty")
public class FacultyController {
    private FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Faculty> getFacultyInfo(@PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.notFound().build();
        }
        Faculty faculty = facultyService.findFaculty(id);
        return ResponseEntity.ok(faculty);
    }

    @PostMapping
    public Faculty createFaculty (@RequestBody Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    @PutMapping
    public ResponseEntity<Faculty> editeFaculty(@RequestBody Faculty faculty) {
        if (faculty == null) {
            return ResponseEntity.notFound().build();
        }
        Faculty foundFaculty = facultyService.editeFaculty(faculty);
        return ResponseEntity.ok(foundFaculty);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteFaculty (@PathVariable Long id) {
        facultyService.removeFaculty(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/colorAndName")
    public ResponseEntity<List<Faculty>> getFacultiesByNameOrColor (@RequestParam (required = false) String name, @RequestParam (required = false) String color) {
        List<Faculty> faculties = facultyService.findFacultiesByNameOrColor(name,color);
        return ResponseEntity.ok(faculties);
    }

    @GetMapping("/student")
    public ResponseEntity<List<Student>> getAllStudentByFacultyId(@RequestParam Long id) {
        return ResponseEntity.ok(facultyService.findAllStudentByFacultyId(id));
    }
}
