package com.srt.studentdatamanagement.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.srt.studentdatamanagement.entity.Teacher;
import com.srt.studentdatamanagement.util.EntityManagerUtil;

public class TeacherRepositoryImp implements TeacherRepository {
	
@Override	
public String saveTeacher(Teacher teacher) {
		EntityManager entityManager = EntityManagerUtil.entityManagerUtil();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(teacher);
		transaction.commit();
		return "data saved successfully";
	
}

@Override
public Teacher getTeacherByID(int id) {
	EntityManager entityManager=EntityManagerUtil.entityManagerUtil();
	return entityManager.find(Teacher.class, id);
}

@Override
public Teacher updateTeacher(Teacher teacher) {
	try {
		EntityManager entityManager = EntityManagerUtil.entityManagerUtil();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Teacher teach=entityManager.merge(teacher);
		transaction.commit();
		return teach;
	}catch (Exception e) {
		System.err.println("data not saved");
	}
return null;
}

@Override
public Teacher deleteTeacher(int id) {
	try {
		EntityManager entityManager=EntityManagerUtil.entityManagerUtil();
		EntityTransaction transaction = entityManager.getTransaction();
		Teacher teacher=entityManager.find(Teacher.class, id);
		
		transaction.begin();
		if(teacher!=null) {
			entityManager.remove(teacher);
		}else {
			return null;
		}
		transaction.commit();
		return teacher;
		
	}catch (Exception e) {
		// TODO: handle exception
		System.err.println("data not saved");
	}
	return null;
}

@Override
public List<Teacher> getAllTeacher() {
	EntityManager manager=EntityManagerUtil.entityManagerUtil();
	
	Query query = manager.createQuery("SELECT t FROM TEACHER t");
	
	Optional<List> optional=Optional.of(query.getResultList());
	
	if(optional.isPresent()) {
		if(optional.get().size()!=0) {
			return optional.get();
		}
	}
	
	return null;
}

@Override
public Teacher loginByEmail(String email, String password) {
	EntityManager manager = EntityManagerUtil.entityManagerUtil();
	Query query=manager.createQuery("SELECT t FROM Teacher t WHERE t.email=?1 AND t.password");
	query.setParameter(1, email);
	query.setParameter(2, password);
	List list=query.getResultList();
	if(list.size()!=0) {
		return (Teacher) list.get(0);
	}else {
		return null;
	}
}

@Override
public Teacher loginByMobile(String phone, String password) {
	EntityManager manager = EntityManagerUtil.entityManagerUtil();
	
	Query query=manager.createQuery("SELECT t FROM Teacher t WHERE t.phone=?1 AND t.password");
	query.setParameter(1, phone);
	query.setParameter(2, password);
	return (Teacher) query.getResultList().get(0);
}
	
}


