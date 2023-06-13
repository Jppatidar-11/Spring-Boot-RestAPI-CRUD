package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Student;

public interface StudentService {
	Student createStudent(Student student);

    Student getStudentById(long userId);

    List<Student> getAllStudents();

    Student updateStudent(Student student);

    void deleteStudent(long userId);

}
