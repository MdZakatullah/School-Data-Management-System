package com.srt.studentdatamanagement.repository;

import java.util.List;

import com.srt.studentdatamanagement.entity.Teacher;

public interface TeacherRepository {
	String saveTeacher(Teacher teacher);
	
	Teacher getTeacherByID(int id);
	
	Teacher updateTeacher(Teacher teacher);
	
	Teacher deleteTeacher(int id);
	
	List<Teacher> getAllTeacher();
	
	Teacher loginByMobile(String phone, String password);

	Teacher loginByEmail(String email, String password);

}
