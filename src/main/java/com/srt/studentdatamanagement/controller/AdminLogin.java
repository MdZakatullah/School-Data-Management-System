package com.srt.studentdatamanagement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srt.studentdatamanagement.entity.Admin;
import com.srt.studentdatamanagement.repository.AdminRepository;
import com.srt.studentdatamanagement.repository.AdminRepositoryImp;

public class AdminLogin extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		
		AdminRepository adminRepositoryImp = new AdminRepositoryImp();
		Admin admin = adminRepositoryImp.loginByEmail(email, pass);
		
		if(admin!=null) {
			resp.sendRedirect("adminMenu.jsp");
		}else {
			resp.sendRedirect("invalidAdmin.jsp");	
		}

	}

}
