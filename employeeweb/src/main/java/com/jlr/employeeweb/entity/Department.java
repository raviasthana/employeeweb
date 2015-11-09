package com.jlr.employeeweb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="DEPARTMENTS")
public class Department implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DEPARTMENT_ID")
	private long departmentId;
	@Column(name="DEPARTMENT_NAME")
	private String departmentName;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MANAGER_ID")
	private Employee manager;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="LOCATION_ID", nullable=false)
	private Location location;
	
	public long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Employee getManager() {
		return manager;
	}
	public void setManager(Employee manager) {
		this.manager = manager;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
}
