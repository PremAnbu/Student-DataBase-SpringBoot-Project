package com.jsp.springboot.MySBApp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springboot.MySBApp.entity.Student;
import com.jsp.springboot.MySBApp.service.StudentService;
import com.jsp.springboot.MySBApp.utility.ResponseStructure;

@RestController
public class StudentController {

	@Autowired
	StudentService stdService;
	@Autowired
	Student std;
	// we can access hear also or create common class common for every one eg=> LoggerAspect.java
    // Logger log=LoggerFactory.getLogger(StudentController.class);


	@PostMapping(value = "/save")
	public ResponseEntity<ResponseStructure<Student>> saveStudent(@RequestBody Student student) {
		return stdService.saveStudent(student);
	}

//	@PostMapping(value = "/update")
//	public ResponseEntity<ResponseStructure<Student>> updateStudent(@RequestBody Student student) {
//		return stdService.updateStudent(student);
//	}
	
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<ResponseStructure<Student>> updateStudent(@PathVariable int id,@RequestBody Student student) {
//		log.info("updateStudentById() method invoked");
		return stdService.updateStudent(id,student);
	}

	@PostMapping(value = "/delete")
	public ResponseEntity<ResponseStructure<Student>> deleteStudent(@RequestBody Student student) {
		return stdService.deleteStudent(student);
	}

	@GetMapping(value = "/getById")
	public ResponseEntity<ResponseStructure<Student>> getStudentById(@RequestBody Student student) {
		return stdService.getStudentById(student);
	}

	@GetMapping(value = "/getAll")
	public ResponseEntity<ResponseStructure<List<Student>>> getAllStudent() {
		return stdService.getAllStudent();
	}

//	@PostMapping(path = "/save")
//	public ResponseEntity<Student> getStudentDetail(@RequestParam int studentId, @RequestParam String studentName,
//			@RequestParam long studentContact) {
//		std.setStudentId(studentId);
//		std.setStudentName(studentName);
//		std.setStudentContact(studentContact);
//
////		return ResponseEntity.status(HttpStatus.OK).body(std);
//		return new ResponseEntity<Student>(stdService.saveStudentDetail(std),HttpStatus.CREATED);
//	}
//	
//	@GetMapping(value = "/studentId/{studentId}")
//	public ResponseEntity<ResponseStructure<Student>> getStudentById(@PathVariable int studentId ){
//		return stdService.getStudentById(studentId );
//		
//	}
//	@PostMapping(path = "/getstudent")
//	public Student getStudentDetail(@RequestParam int studentId, @RequestParam String studentName,
//			@RequestParam long studentContact) {
//
//		return stdService.saveStudentDetail(studentId, studentName, studentContact);
//	}

//	@GetMapping(path = "/getstudent")
//	public Student getStudentDetail(@RequestParam int studentId, @RequestParam String studentName,
//			@RequestParam long studentContact) {
//
//		return stdService.saveStudentDetail(studentId, studentName, studentContact);
//	}

//	@RequestMapping(path = "/getstudent", method = RequestMethod.POST)
//	public Student getStudentDetail(@RequestParam int studentId, @RequestParam String studentName,
//			@RequestParam long studentContact) {
//
//		return stdService.saveStudentDetail(studentId, studentName, studentContact);
//	}

}
