package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepo;

	@Override
	public Student createStudent(Student student) {
		
		return studentRepo.save(student);
	}

	@Override
	public Student getStudentById(long studentId) {
		Optional<Student> optionalStudent=studentRepo.findById(studentId);
		return optionalStudent.orElse(null);
	}

	@Override
	public List<Student> getAllStudents() {
		
		return studentRepo.findAll();
	}

	@Override
	public Student updateStudent(Student student) {
		
		 Student existingStudent = studentRepo.findById(student.getId()).get();
		 existingStudent.setName(student.getName());
		 existingStudent.setDOB(student.getDOB());
		 existingStudent.setClassSection(student.getClassSection());
		 existingStudent.setAddress(student.getAddress());
		
		return studentRepo.save(existingStudent);
	}

	@Override
	public void deleteStudent(long studentId) {
		
		 studentRepo.deleteById(studentId);
	}
	

}
