package com.project1.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PatchExchange;

import com.project1.employee.entity.Student;
import com.project1.employee.service.StudentService;
import com.project1.employee.serviceimpl.StoredProcedureService;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;

	@PostMapping("addStudents")
	public String Post(@RequestBody Student s) {
		String student = service.saveStudent(s);
		return student;
	}

	@GetMapping("getStudents")
	public List<Student> getBranch(@RequestParam String branch) {
		List<Student> branch2 = service.findBranch(branch);
		return branch2;
	}

	@GetMapping("getStudentYear/{year}")
	public List<Student> getYear(@PathVariable("year") int year) {
		List<Student> year2 = service.getYear(year);
		return year2;
	}

	@PatchMapping("updateCname")
	public String Single(@RequestParam int id, @RequestParam String Cname) {
		String partialUpdate = service.partialUpdate(id, Cname);
		return partialUpdate;
	}

	@PatchMapping("updateBranch")
	public String updateBranch(@RequestParam int id, @RequestParam String branch) {
		String update = service.update(id, branch);
		return update;
	}

	@DeleteMapping("deleteMobile")
	public String delete(@RequestParam long mobile) {
		System.out.println("Control layer...");
		if (service.deleteMob(mobile) == true)
			return "Deleted";
		else
			return "Not deleted";
	}

	@DeleteMapping("deleteId")
	public String delete(@RequestParam int id) {
		return service.delete(id);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Optional<Student>> getStudentById(@PathVariable int id) {
		return ResponseEntity.status(302).body(service.getId(id));
	}

	@Autowired
	private StoredProcedureService storedProcedureService; // Stored Procedure Autowired Here

	@GetMapping("getTwo")
	public List getStudentYear() {
		return storedProcedureService.getYearGreaterThanTwo();
	}

	@GetMapping("getInParameter")
	public List getInParameter(@RequestParam int id) {
		return storedProcedureService.getByYearInParameter(id);

	}

	@GetMapping("getOutParameter")
	public Object getOutParameter() {
		return storedProcedureService.nameOfOUTparameter();

	}

	@GetMapping("getInOutParameter")
	public Object getInOutParameter(@RequestParam int id) {
		return storedProcedureService.getNameByIdInandOutparameter(id);
	}

	@GetMapping("/karthik1")
	public List<Object> getKarthik(@RequestParam int id) {
		return storedProcedureService.getIdByInAndOut(id);
	}
	
	@GetMapping("/pagination")
	public Page<Student> getByPage(@RequestParam int pagenumber , @RequestParam int numberOfItems){
		return service.pagination(pagenumber, numberOfItems);
		
	}
	

}