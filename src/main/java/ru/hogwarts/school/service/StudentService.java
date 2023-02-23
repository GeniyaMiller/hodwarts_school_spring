package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.*;

@Service
public class StudentService {
   private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent (Student student) {
        return studentRepository.save(student);
    }

    public Student findStudent (Long id) {
        return studentRepository.findById(id).get();
    }

    public Student editeStudent (Student student) {
        return studentRepository.save(student);
    }

    public void removeStudent (Long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> getStudentsForAgeBetween(int ageMin, int ageMax) {
        return studentRepository.findByAgeBetween(ageMin,ageMax);
    }

    public Faculty findFacultyByStudentId(Long id) {
        return findStudent(id).getFaculty();
    }
}
