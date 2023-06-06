package com.srt.studentdatamanagement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.srt.studentdatamanagement.entity.Teacher;
import com.srt.studentdatamanagement.repository.TeacherRepository;
import com.srt.studentdatamanagement.repository.TeacherRepositoryImp;

@WebServlet("/teacherLogin")
public class TeacherLoginByEmail extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String pass=req.getParameter("password");
		
		TeacherRepository repository = new TeacherRepositoryImp();
		
		Teacher teacher=repository.loginByEmail(email, pass);
		HttpSession session = req.getSession();	
		
		if(teacher!=null) {
			session.setAttribute("teacher", teacher);
			
			resp.sendRedirect("teacherMenu.jsp");
		}else {
			session.setAttribute("teacher", null);
			resp.sendRedirect("invalidTeacher.jsp");
		}
	}

}
