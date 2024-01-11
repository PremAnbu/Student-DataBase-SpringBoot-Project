package com.jsp.springboot.MySBApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springboot.MySBApp.entity.Student;
import com.jsp.springboot.MySBApp.exception.StudentNotFoundByIdException;
import com.jsp.springboot.MySBApp.repository.StudentRepository;
import com.jsp.springboot.MySBApp.utility.ResponseStructure;

@Service
public class StudentService {

	@Autowired
	Student std;
	@Autowired
	StudentRepository stdRepository;
	@Autowired
	ResponseStructure<Student> responseStructure;
	@Autowired
	ResponseStructure<List<Student>> listResponseStructure;

	public ResponseEntity<ResponseStructure<Student>> saveStudent(Student student) {
		Student stud = stdRepository.save(student);
		if ((stud != null)) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Student data saved !!!");
			responseStructure.setData(stud);

			return new ResponseEntity<ResponseStructure<Student>>(responseStructure, HttpStatus.FOUND);
		} else
			return null;
	}

	public ResponseEntity<ResponseStructure<Student>> deleteStudent(Student student) {
		Optional<Student> findById = stdRepository.findById(student.getStudentId());
		if (findById.isPresent()) {
			responseStructure.setStatus(HttpStatus.GONE.value());
			responseStructure.setMessage("Student data Deleted !!!");
			responseStructure.setData(findById.get());
			stdRepository.deleteById(student.getStudentId());

			return new ResponseEntity<ResponseStructure<Student>>(responseStructure, HttpStatus.GONE);
		} else {
//			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
//			responseStructure.setMessage("Student data Not Found !!!");
//			return new ResponseEntity<ResponseStructure<Student>>(responseStructure, HttpStatus.NOT_FOUND);
			throw new StudentNotFoundByIdException("Failed to find the student !!");
		}
	}

//	public ResponseEntity<ResponseStructure<Student>> updateStudent(Student student) {
//		Optional<Student> findById = stdRepository.findById(student.getStudentId());
//		if (findById.isPresent()) {
//			Student stud = stdRepository.save(student);
//			responseStructure.setStatus(HttpStatus.OK.value());
//			responseStructure.setMessage("Student data Updated !!!");
//			responseStructure.setData(stud);
//
//			return new ResponseEntity<ResponseStructure<Student>>(responseStructure, HttpStatus.OK);
//		} else {
//			throw new StudentNotFoundByIdException("Failed to find the student !!");
//
//		}
//	}
	public ResponseEntity<ResponseStructure<Student>> updateStudent(int id,Student updatestudent) {
		Optional<Student> findById = stdRepository.findById(id);
		if (findById.isPresent()) {
			
			Student exStd=findById.get();
			exStd=mapByStudent(exStd,updatestudent);
			stdRepository.save(exStd);
			
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Student data Updated !!!");
			responseStructure.setData(exStd);

			return new ResponseEntity<ResponseStructure<Student>>(responseStructure, HttpStatus.OK);
		} else {
			throw new StudentNotFoundByIdException("Failed to find the student !!");

		}
	}
	
	
	private Student mapByStudent(Student exStd, Student updatestudent) {
	 exStd.setStudentName(updatestudent.getStudentName());
	 exStd.setStudentContact(updatestudent.getStudentContact());
	return exStd;
}

	//=================
	public ResponseEntity<ResponseStructure<Student>> getStudentById(Student student) {
		Optional<Student> findById = stdRepository.findById(student.getStudentId());
		if (findById.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Student data Found!!!");
			responseStructure.setData(findById.get());

			return new ResponseEntity<ResponseStructure<Student>>(responseStructure, HttpStatus.OK);
		} else {
//			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
//			responseStructure.setMessage("Student data Not Found !!!");
//			return new ResponseEntity<ResponseStructure<Student>>(responseStructure, HttpStatus.NOT_FOUND);
			throw new StudentNotFoundByIdException("Failed to find the student !!");

		}
	}

	public ResponseEntity<ResponseStructure<List<Student>>> getAllStudent() {
		List<Student> findAll = stdRepository.findAll();
		if (!findAll.isEmpty()) {
			listResponseStructure.setStatus(HttpStatus.OK.value());
			listResponseStructure.setMessage("Student data Found!!!");
			listResponseStructure.setData(findAll);

			return new ResponseEntity<ResponseStructure<List<Student>>>(listResponseStructure, HttpStatus.OK);
		} else {
//			listResponseStructure.setStatus(HttpStatus.NOT_FOUND.value());
//			listResponseStructure.setMessage("Student data Not Found !!!");
//			return new ResponseEntity<ResponseStructure<List<Student>>>(listResponseStructure, HttpStatus.NOT_FOUND);
			throw new StudentNotFoundByIdException("Failed to find the student !!");

		}
	}

//	public Student saveStudentDetail(Student std) {
//		return stdRepository.save(std);
//		
//	}
//
//	public ResponseEntity<ResponseStructure<Student>> getStudentById(int studentId) {
//	    Optional<Student> findById = stdRepository.findById(studentId);
//	    if((findById != null)) {
//	    	responseStructure.setStatus(HttpStatus.FOUND.value());
//	    	responseStructure.setMessage("Student data found !!!");
//	    	responseStructure.setData(findById.get());
//	    	
//	    	return new ResponseEntity<ResponseStructure<Student>>(responseStructure,HttpStatus.FOUND);
//	    }
//	    else
//	    	return null;
//	}

}
