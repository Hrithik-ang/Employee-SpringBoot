package com.project1.employee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;

@Entity
@NamedStoredProcedureQueries({ @NamedStoredProcedureQuery(name = "karthikProcedure", procedureName = "yearGreaterTwo"),
		@NamedStoredProcedureQuery(name = "getByYearInParameter", procedureName = "getByYearInParameter", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "n") }),
        
		@NamedStoredProcedureQuery(name = "nameOfOUTparameter", procedureName = "nameOfOUTparameter", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "n") }),
        
		@NamedStoredProcedureQuery(name = "getNameByIdInandOutparameter", procedureName = "getNameByIdInandOutparameter", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "n"),
				@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "name") }),
		
		
		@NamedStoredProcedureQuery(name = "getIdByInAndOut", procedureName = "getIdByInAndOut", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "n"),
				@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "a"),
				@StoredProcedureParameter(mode = ParameterMode.OUT, type = Long.class, name = "b"),
				@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "c"),
				@StoredProcedureParameter(mode = ParameterMode.OUT, type = Integer.class, name = "d"),
				@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "e") }) 
})        
public class Student {
	@Id
	private int id;

	@Column(name = "year")
	private int year;

	@Column(name = "student_name")
	private String name;

	private String branch;

	@Column(name = "college_name")
	private String Cname;

	@Column(nullable = false, unique = true)
	private long mobile;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int id, int year, String name, String branch, long mobile, String cname) {
		super();
		this.id = id;
		this.year = year;
		this.name = name;
		this.branch = branch;
		this.mobile = mobile;
		this.Cname = cname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getCname() {
		return Cname;
	}

	public void setCname(String cname) {
		this.Cname = cname;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", year=" + year + ", name=" + name + ", branch=" + branch + ", Cname=" + Cname
				+ ", mobile=" + mobile + "]";
	}

}
