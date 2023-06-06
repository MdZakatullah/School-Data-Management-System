package com.srt.studentdatamanagement.repository;

import java.util.List;

import com.srt.studentdatamanagement.entity.Student;

public interface StudentRepository {
	
	String saveStudent(Student student);
	
    Student getStudentByID(int id);
	
    Student updateStudent(Student student);
	
    Student deleteStudent(int id);
	
	List<Student> getAllStudent();
	
	Student loginByMobile(String phone, String password);

	Student loginByEmail(String email, String password);

}
