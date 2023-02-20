package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FacultyService {

    private FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty (Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty (Long id) {

        return facultyRepository.findById(id).get();
    }

    public Faculty editeFaculty (Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public void removeFaculty (Long id) {
        facultyRepository.deleteById(id);
    }


    public List<Faculty> getFacultiesForColor(String color) {
        return facultyRepository.findByColor(color);
    }
}

