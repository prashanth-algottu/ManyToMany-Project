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
@Table(name = "employee")
public class Employees 
{
	@Id
	private int id;
	private String name;
	
	@ManyToMany(cascade = {CascadeType.DETACH,
			CascadeType.MERGE,CascadeType.PERSIST,
			CascadeType.REFRESH })
	@JoinTable(name = "employee_project", 
			joinColumns = @JoinColumn(name="project_id"),
			inverseJoinColumns = @JoinColumn(name=" emp_id "))
	private List<Projects> projects;
	
	public List<Projects> getProjects() {
		return projects;
	}

	public void setProjects(List<Projects> projects) {
		this.projects = projects;
	}

	public Employees() {
		// TODO Auto-generated constructor stub
	}

	public Employees(int id, String name) {
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
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	

}
