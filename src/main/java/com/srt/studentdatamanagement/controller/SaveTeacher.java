package com.srt.studentdatamanagement.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srt.studentdatamanagement.entity.Teacher;
import com.srt.studentdatamanagement.repository.TeacherRepositoryImp;
@WebServlet("/SaveTeacher")
public class SaveTeacher extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Teacher teacher = new Teacher();
		teacher.setId(104);
		teacher.setName("sohan");
		teacher.setAddress("delhi");
		teacher.setClassTeacher("8B");
		teacher.setJoiningDate(Date.valueOf(LocalDate.of(2020, 03, 02)));
		teacher.setPassword("1125");
		teacher.setPhone("935087123");
		teacher.setQualification("B.sc");
		teacher.setGender("Male");
		teacher.setEmail("r67@gmail.com");
		teacher.setExperience("1");
		teacher.setSubject("javaScript");
		teacher.setSalary("12000");
		
		TeacherRepositoryImp repository = new TeacherRepositoryImp();
		repository.saveTeacher(teacher);
	}
	

}
