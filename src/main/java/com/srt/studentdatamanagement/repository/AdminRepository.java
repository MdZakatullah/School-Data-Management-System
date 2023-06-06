package com.srt.studentdatamanagement.repository;

import java.util.List;

import com.srt.studentdatamanagement.entity.Admin;

public interface AdminRepository {
	
    String saveAdmin(Admin admin);
	
    Admin getAdmintByID(int id);
	
    Admin updateAdmin(Admin admin);
	
    Admin deleteAdmin(int id);
	
	List<Admin> getAllAdmin();
	
	Admin loginByMobile(String phone, String password);

	Admin loginByEmail(String email, String password);

}
