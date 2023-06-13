package com.example.demo.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
    
	@PostMapping()
	public ResponseEntity<Student> addStudent(@RequestBody Student student){
		Student savedStudent=studentService.createStudent(student);
		return new ResponseEntity<>(savedStudent,HttpStatus.CREATED);
	}
	
	@GetMapping()
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> students=studentService.getAllStudents();
		return new ResponseEntity<>(students,HttpStatus.OK);
	}
	
	 @GetMapping("{id}")
	    public ResponseEntity<Student> getStudentById(@PathVariable("id") long studentId){
	        Student student = studentService.getStudentById(studentId);
	        return new ResponseEntity<>(student, HttpStatus.OK);
	    }
	 
	  @PutMapping("{id}")
	    public ResponseEntity<Student> updateStudent(@PathVariable("id") long studentId,@RequestBody Student student){
	          student.setId(studentId);
	        Student updatedStudent = studentService.updateStudent(student);
	        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
	    }
	  
	  @DeleteMapping("{id}")
	    public ResponseEntity<String> deleteUser(@PathVariable("id") Long studentId){
	       studentService.deleteStudent(studentId);
	        return new ResponseEntity<>("Student successfully deleted!", HttpStatus.OK);
	    }
}
