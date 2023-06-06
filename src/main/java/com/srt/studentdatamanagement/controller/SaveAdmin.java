package com.srt.studentdatamanagement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srt.studentdatamanagement.entity.Admin;
import com.srt.studentdatamanagement.repository.AdminRepositoryImp;

@WebServlet("/saveAdmin")
public class SaveAdmin extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Admin admin = new Admin();
		admin.setId(4);
		admin.setName("shivam");
		admin.setEmail("sh2@gmail.com");
		admin.setPassword("897");
		
		AdminRepositoryImp adminRepositoryImp = new AdminRepositoryImp();
		adminRepositoryImp.saveAdmin(admin);
	}

}
