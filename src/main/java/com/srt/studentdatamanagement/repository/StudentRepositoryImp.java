package com.srt.studentdatamanagement.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.srt.studentdatamanagement.entity.Student;
import com.srt.studentdatamanagement.util.EntityManagerUtil;

public class StudentRepositoryImp implements StudentRepository{

	@Override
	public String saveStudent(Student student) {
		EntityManager entityManager = EntityManagerUtil.entityManagerUtil();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(student);
		transaction.commit();
		return "data saved successfully";	
	}

	@Override
	public Student getStudentByID(int id) {
		EntityManager entityManager=EntityManagerUtil.entityManagerUtil();
		return entityManager.find(Student.class, id);
	}

	@Override
	public Student updateStudent(Student student) {
		try {
			EntityManager entityManager = EntityManagerUtil.entityManagerUtil();
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			Student stud=entityManager.merge(student);
			transaction.commit();
			return stud;
		}catch (Exception e) {
			System.err.println("data not saved");
		}
	return null;
	}
	
	@Override
	public Student deleteStudent(int id) {
		try {
			EntityManager entityManager=EntityManagerUtil.entityManagerUtil();
			EntityTransaction transaction = entityManager.getTransaction();
			Student student=entityManager.find(Student.class, id);
			
			transaction.begin();
			if(student!=null) {
				entityManager.remove(student);
			}else {
				return null;
			}
			transaction.commit();
			return student;
			
		}catch (Exception e) {
			System.err.println("data not saved");
		}
		return null;
	}

	@Override
	public List<Student> getAllStudent() {
		EntityManager manager=EntityManagerUtil.entityManagerUtil();
		
		Query query = manager.createQuery("SELECT s FROM STUDENT s");
		
		Optional<List> optional=Optional.of(query.getResultList());
		
		if(optional.isPresent()) {
			if(optional.get().size()!=0) {
				return optional.get();
			}
		}
		return null;
	}

	@Override
	public Student loginByMobile(String phone, String password) {
		EntityManager manager = EntityManagerUtil.entityManagerUtil();
		
		Query query=manager.createQuery("SELECT s FROM Student s WHERE s.phone=?1 AND s.password");
		query.setParameter(1, phone);
		query.setParameter(2, password);
		return (Student) query.getResultList().get(0);
	}

	@Override
	public Student loginByEmail(String email, String password) {
		EntityManager manager = EntityManagerUtil.entityManagerUtil();
		Query query=manager.createQuery("SELECT s FROM Student s WHERE s.email=?1 AND s.password");
		query.setParameter(1, email);
		query.setParameter(2, password);
		List list=query.getResultList();
		if(list.size()!=0) {
			return (Student) list.get(0);
		}else {
			return null;
		}
	}

}
