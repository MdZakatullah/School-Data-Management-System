package com.srt.studentdatamanagement.util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EntityManagerUtil {
	private static EntityManager manager=null;
	
	private EntityManagerUtil() {
		
	}
	
	public static EntityManager entityManagerUtil() {
		if(manager==null) {
			manager=Persistence.createEntityManagerFactory("MdZakatullah")
					.createEntityManager();
		}
		return manager;
	}

}
