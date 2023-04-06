package com.project1.employee.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.project1.employee.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

	public List<Student> findByBranch(String brach);                     //GET BY BRANCH
	
	public List<Student> findByYear(int year);                           //Get BY YEAR
	  
	public String removeByMobile(long mobile);	                         //DELETE BY MOBILE
	
	public ResponseEntity<Student> deleteById(int id);                   //DELETE BY ID
	
//	public Page<Student> findStudentBy(int id , Pageable pageable);      //PAGINATION
	
	
}
