package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.*;

@Service
public class StudentService {
    private Map<Long, Student> studentMap = new HashMap<>();
    private long lastId = 0;

    public Student createStudent (Student student) {
        student.setId(++lastId);
        studentMap.put(lastId, student);
        return student;
    }

    public Student findStudent (Long id) {
        if (studentMap.containsKey(id)) {
            return studentMap.get(id);
        }
        return null;
    }

    public Student editeStudent (Student student) {
        if (studentMap.containsKey(student.getId())) {
            studentMap.put(student.getId(), student);
            return student;
        }
        return null;
    }

    public Student removeStudent (Long id) {
        if (studentMap.containsKey(id)) {
            return studentMap.remove(id);
        }
        return null;
    }

    public List<Student> getStudentsForAge(int age) {
        List<Student> students = studentMap.values().stream().filter(student -> student.getAge() = age).toList();
        return students;

    }
}
