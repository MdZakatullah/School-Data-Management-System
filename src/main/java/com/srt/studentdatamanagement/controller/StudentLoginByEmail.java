package com.srt.studentdatamanagement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.srt.studentdatamanagement.entity.Student;
import com.srt.studentdatamanagement.repository.StudentRepository;
import com.srt.studentdatamanagement.repository.StudentRepositoryImp;

@WebServlet("/studentLogin")
public class StudentLoginByEmail extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String pass=req.getParameter("password");
		
		StudentRepository repositoryImp = new StudentRepositoryImp();
		Student student = repositoryImp.loginByEmail(email, pass);
		HttpSession session = req.getSession();
		
		if(student!=null) {
			session.setAttribute("student", student);
			
			resp.sendRedirect("studentMenu.jsp");
		}else {
			session.setAttribute("student", null);
			resp.sendRedirect("invalidStudent.jsp");
		}
	}

}
