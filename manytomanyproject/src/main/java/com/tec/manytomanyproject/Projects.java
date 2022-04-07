package com.tec.manytomanyproject;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Projects 
{
	@Id
	private int id;
	private String name;
	
	@ManyToMany(cascade = {CascadeType.DETACH,
			CascadeType.MERGE,CascadeType.PERSIST,
			CascadeType.REFRESH })
	@JoinTable(name = "employee_project", 
			joinColumns = @JoinColumn(name="emp_id"),
			inverseJoinColumns = @JoinColumn(name="project_id"))
	private List<Employees> employees;
	
	public List<Employees> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employees> employees) {
		this.employees = employees;
	}
	public Projects() {
		// TODO Auto-generated constructor stub
	}
	public Projects(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + "]";
	}

	
}
