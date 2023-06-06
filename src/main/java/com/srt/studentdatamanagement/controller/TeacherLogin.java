package com.srt.studentdatamanagement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srt.studentdatamanagement.entity.Teacher;
import com.srt.studentdatamanagement.repository.TeacherRepository;
import com.srt.studentdatamanagement.repository.TeacherRepositoryImp;

public class TeacherLogin  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		
		TeacherRepository repository = new TeacherRepositoryImp();
		Teacher teacher=repository.loginByEmail(email,pass);
		
		if(teacher!=null) {
			resp.sendRedirect("teacherMenu.jsp");
		}else {
			resp.sendRedirect("invalidTeacher.jsp");	
		}
	}

}
