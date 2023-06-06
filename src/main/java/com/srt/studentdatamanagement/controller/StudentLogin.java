package com.srt.studentdatamanagement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srt.studentdatamanagement.entity.Student;
import com.srt.studentdatamanagement.repository.StudentRepository;
import com.srt.studentdatamanagement.repository.StudentRepositoryImp;

public class StudentLogin extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		
		StudentRepository repositoryImp = new StudentRepositoryImp();
		Student student = repositoryImp.loginByEmail(email, pass);
		
		if(student!=null) {
			resp.sendRedirect("studentMenu.jsp");
		}else {
			resp.sendRedirect("invalidStudent.jsp");	
		}

	}

}
