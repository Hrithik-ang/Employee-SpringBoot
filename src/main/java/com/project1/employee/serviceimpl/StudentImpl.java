package com.project1.employee.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project1.employee.entity.Student;
import com.project1.employee.repository.StudentRepo;
import com.project1.employee.service.StudentService;

import jakarta.transaction.Transactional;

@Service
public class StudentImpl implements StudentService {

	@Autowired
	private StudentRepo repoStudent;

	@Override
	public String saveStudent(Student s) {                                      //SAVE STUDENT
		repoStudent.save(s);
		return " Data is added Successfully";
	}

	@Override
	public List<Student> findBranch(String branch) {                            //GET STUDENT BRANCH 
		List<Student> findByBranch = repoStudent.findByBranch(branch);
		return findByBranch;
	}

	@Override
	public List<Student> getYear(int year) {                                    //GET YEAR
		List<Student> findByYear = repoStudent.findByYear(year);
		return findByYear;
	}
  
	@Override                                                                   //UPDATE     COLLEGE NAME
	public String partialUpdate(int id, String Cname) {
		Student st = repoStudent.getById(id);
		st.setCname(Cname);
		repoStudent.save(st);
		return "College name updated";
	}

	@Override                                                                   //UPDATE  BRANCH
	public String update(int id, String branch) {
		Student st = repoStudent.getById(id);
		st.setBranch(branch);
		repoStudent.save(st);
		return "change of branch is done successfully";
	}

	@Transactional
	@Override                                                                   //DELETE MOBILE 
	public boolean deleteMob(long mobile) {
		System.out.println("\nService layer");
		repoStudent.removeByMobile(mobile);
//		repoStudent.deleteByMobile(mobile);
		return true;
	}

	@Override 
	public String delete(int id) {                                              //DELETE ID
		repoStudent.deleteById(id); 
		return "Deleted...";
	}

	@Override 
	public Optional<Student> getId(int id) {                                    //GEY BY ID 
		return repoStudent.findById(id); 
	}

	@Override
	public Page<Student> pagination(int pagenumber , int numberOfItems) {       //PAGINATION
		PageRequest sort=PageRequest.of(pagenumber ,numberOfItems,Sort.by("id").descending());                                       //PAGINATION
		Page<Student> findById = repoStudent.findAll(sort);
		return findById;
	}
 
}
