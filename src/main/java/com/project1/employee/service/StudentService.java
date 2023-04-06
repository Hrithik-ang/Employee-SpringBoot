package com.project1.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project1.employee.entity.Student;

import jakarta.transaction.Transactional;

@Service
public interface StudentService {

	public String saveStudent(Student s);                      // POST METHOD
	
	public List<Student> findBranch(String branch);            //GET BRANCH METHOD

    public List<Student> getYear(int year);                    //GET YEAR METHOD

    public String partialUpdate(int id , String Cname);        // PATCH (UPDATE) METHOD Cname

    public String update(int id , String branch);              // PUT METHOD (UPDATE)
 
    public boolean deleteMob(long mobile);                     //DELETE METHOD 
    
    public String delete(int id);                              //DELETE ID
    
    public Optional<Student> getId(int id);                    //GET BY ID
    
    public Page<Student> pagination(int id,int n);             //PAGINATION
 
    
    
}
