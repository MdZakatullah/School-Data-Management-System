package com.srt.studentdatamanagement.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.srt.studentdatamanagement.entity.Admin;
import com.srt.studentdatamanagement.util.EntityManagerUtil;

public class AdminRepositoryImp implements AdminRepository{

	@Override
	public String saveAdmin(Admin admin) {
		EntityManager entityManager = EntityManagerUtil.entityManagerUtil();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(admin);
		transaction.commit();
		return "data saved successfully";	
	}

	@Override
	public Admin getAdmintByID(int id) {
		EntityManager entityManager=EntityManagerUtil.entityManagerUtil();
		return entityManager.find(Admin.class, id);
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		try {
			EntityManager entityManager = EntityManagerUtil.entityManagerUtil();
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			Admin adm=entityManager.merge(admin);
			transaction.commit();
			return adm;
		}catch (Exception e) {
			System.err.println("data not saved");
		}
		return null;
	}

	@Override
	public Admin deleteAdmin(int id) {
		try {
			EntityManager entityManager=EntityManagerUtil.entityManagerUtil();
			EntityTransaction transaction = entityManager.getTransaction();
			Admin admin=entityManager.find(Admin.class, id);
			
			transaction.begin();
			if(admin!=null) {
				entityManager.remove(admin);
			}else {
				return null;
			}
			transaction.commit();
			return admin;
			
		}catch (Exception e) {
			System.err.println("data not saved");
		}
		return null;
	}

	@Override
	public List<Admin> getAllAdmin() {
        EntityManager manager=EntityManagerUtil.entityManagerUtil();
		
		Query query = manager.createQuery("SELECT a FROM ADMIN a");
		
		Optional<List> optional=Optional.of(query.getResultList());
		
		if(optional.isPresent()) {
			if(optional.get().size()!=0) {
				return optional.get();
			}
		}
		return null;
	}

	@Override
	public Admin loginByMobile(String phone, String password) {
        EntityManager manager = EntityManagerUtil.entityManagerUtil();
		
		Query query=manager.createQuery("SELECT a FROM Admin a WHERE a.phone=?1 AND a.password");
		query.setParameter(1, phone);
		query.setParameter(2, password);
		return (Admin) query.getResultList().get(0);

	}

	@Override
	public Admin loginByEmail(String email, String password) {
		EntityManager manager = EntityManagerUtil.entityManagerUtil();
		Query query=manager.createQuery("SELECT a FROM Admin a WHERE a.email=?1 AND a.password");
		query.setParameter(1, email);
		query.setParameter(2, password);
		List list=query.getResultList();
		if(list.size()!=0) {
			return (Admin) list.get(0);
		}else {
		return null;
	}

}
}
