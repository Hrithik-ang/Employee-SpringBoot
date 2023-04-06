package com.project1.employee.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project1.employee.repository.StudentRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

@Service
public class StoredProcedureService {

	@Autowired
	private StudentRepo repo;

	@Autowired
	@PersistenceContext
	private EntityManager entityManager;

	public List getYearGreaterThanTwo() {
		return entityManager.createNamedStoredProcedureQuery("karthikProcedure").getResultList();
	}

	public List getByYearInParameter(int id) {
		return entityManager.createNamedStoredProcedureQuery("getByYearInParameter").setParameter("n", id)
				.getResultList();
	}

	public Object nameOfOUTparameter() {
		return entityManager.createNamedStoredProcedureQuery("nameOfOUTparameter").getOutputParameterValue("n");

	}
	
	public Object getNameByIdInandOutparameter(int id) {
		return entityManager.createNamedStoredProcedureQuery("getNameByIdInandOutparameter").setParameter("n", id).
				getOutputParameterValue("name");
	}

	public List<Object> getIdByInAndOut(int id) {
		StoredProcedureQuery proc = entityManager.createNamedStoredProcedureQuery("getIdByInAndOut").setParameter("n", id);
		
		List<Object> list = new ArrayList<>();
		
		String a=(String) proc.getOutputParameterValue("a");
		Long b=(Long) proc.getOutputParameterValue("b");
		String c=(String) proc.getOutputParameterValue("c");
		Integer d=(Integer) proc.getOutputParameterValue("d");
		String e=(String) proc.getOutputParameterValue("e");
//		System.out.println(a+" "+b+" "+c+" "+d+" "+e);
		
		list.add(a);
		list.add(b);
		list.add(c);
		list.add(d);
		list.add(e);
		return list;
	}
}
