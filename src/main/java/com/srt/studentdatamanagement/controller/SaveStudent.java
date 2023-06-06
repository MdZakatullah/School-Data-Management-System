package com.srt.studentdatamanagement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srt.studentdatamanagement.entity.Student;
import com.srt.studentdatamanagement.repository.StudentRepositoryImp;

@WebServlet("/saveStudent")
public class SaveStudent extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student student = new Student();
		student.setId(2);
		student.setName("Devendra");
		student.setGender("Male");
		student.setEmail("d2@gmail.com");
		student.setPassword("1234");
		student.setAddress("mumbai");
		student.setPhone("98708761238");
		student.setClassName("10B");
		student.setFee("3000");
		student.setMarks("85%");
		
		StudentRepositoryImp repositoryImp = new StudentRepositoryImp();
		repositoryImp.saveStudent(student);
	}

}
