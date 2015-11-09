package com.jlr.employeeweb.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="EMPLOYEES")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private EmployeeId employeeId;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="EMAIL")
	private String email;
	@Column(name="PHONE_NUMBER")
	private String phoneNumber;
	@Temporal(TemporalType.DATE)
	@Column(name="HIRE_DATE")
	private Date hireDate;
	@Column(name="SALARY")
	private BigDecimal salary;
	@Column(name="COMMISSION_PCT")
	private BigDecimal commissionPct;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="JOB_ID", nullable=false)
	private Job job;
	
	@ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="MANAGER_ID", nullable=true)
	private Employee manager;
	
	@OneToMany(mappedBy="manager")
	private Set<Employee> subordinates = new HashSet<>();
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DEPARTMENT_ID")
	private Department department;
	
	@OneToMany(mappedBy="employee")
	private Set<JobHistory> jobHistory = new HashSet<>();
	
	public Set<JobHistory> getJobHistory() {
		return jobHistory;
	}
	public void setJobHistory(Set<JobHistory> jobHistory) {
		this.jobHistory = jobHistory;
	}
	public Set<Employee> getSubordinates() {
		return subordinates;
	}
	public void setSubordinates(Set<Employee> subordinates) {
		this.subordinates = subordinates;
	}	

	public EmployeeId getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(EmployeeId employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public BigDecimal getCommissionPct() {
		return commissionPct;
	}
	public void setCommissionPct(BigDecimal commissionPct) {
		this.commissionPct = commissionPct;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public Employee getManager() {
		return manager;
	}
	public void setManager(Employee manager) {
		this.manager = manager;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
}
