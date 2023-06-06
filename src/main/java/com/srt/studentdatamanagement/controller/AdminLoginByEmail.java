package com.srt.studentdatamanagement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.srt.studentdatamanagement.entity.Admin;
import com.srt.studentdatamanagement.repository.AdminRepository;
import com.srt.studentdatamanagement.repository.AdminRepositoryImp;

@WebServlet("/adminLogin")
public class AdminLoginByEmail extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String pass=req.getParameter("password");
		
		AdminRepository adminRepositoryImp = new AdminRepositoryImp();
		Admin admin = adminRepositoryImp.loginByEmail(email, pass);
		HttpSession session = req.getSession();
		
		if(admin!=null) {
			session.setAttribute("admin", admin);
			
			resp.sendRedirect("adminMenu.jsp");
		}else {
			session.setAttribute("admin", null);
			resp.sendRedirect("invalidAdmin.jsp");
		}

	}

}
