package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FacultyService {
    private Map<Long, Faculty> facultyMap = new HashMap<>();
    private long lastId = 0;

    public Faculty createFaculty (Faculty faculty) {
        faculty.setId(++lastId);
        facultyMap.put(lastId, faculty);
        return faculty;
    }

    public Faculty findFaculty (Long id) {
        return facultyMap.get(id);
    }

    public Faculty editeFaculty (Faculty faculty) {
        facultyMap.put(faculty.getId(),faculty);
        return faculty;
    }

    public Faculty removeFaculty (Long id) {
        return facultyMap.remove(id);
    }


    public List<Faculty> getFacultiesForColor(String color) {
        return facultyMap.values().stream().filter(faculty -> faculty.getColor()=color).toList();
    }
}

