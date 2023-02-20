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
        Faculty Faculty = facultyService.findFaculty(id);
        return ResponseEntity.ok(Faculty);
    }

    @PostMapping
    public Faculty createFaculty (@RequestBody Faculty Faculty) {
        return facultyService.createFaculty(Faculty);
    }

    @PutMapping
    public ResponseEntity<Faculty> editeFaculty(@RequestBody Faculty Faculty) {
        if (Faculty == null) {
            return ResponseEntity.notFound().build();
        }
        Faculty foundFaculty = facultyService.editeFaculty(Faculty);
        return ResponseEntity.ok(foundFaculty);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteFaculty (@PathVariable Long id) {
        facultyService.removeFaculty(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/color")
    public ResponseEntity<List<Faculty>> getFacultiesForColor (@RequestParam String color) {
        if (color == null || color.isBlank()) {
            return ResponseEntity.ok(Collections.emptyList());
        }
        List<Faculty> faculties = facultyService.getFacultiesForColor(color);
        return ResponseEntity.ok(faculties);
    }
}
