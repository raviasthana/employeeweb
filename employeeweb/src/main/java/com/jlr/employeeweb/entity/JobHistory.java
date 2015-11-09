package com.jlr.employeeweb.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="JOB_HISTORY")
public class JobHistory implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private JobHistoryId jobHistoryId;
	
	public JobHistory() {
	}
	
	public JobHistory(JobHistoryId jobHistoryId) {
		this.jobHistoryId = jobHistoryId;
	}	
	
	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="JOB_ID", nullable=false)
	private Job job;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DEPARTMENT_ID")
	private Department department;
	
	@MapsId("employeeId")
	@JoinColumns({
		@JoinColumn(name="JHIST_EMP_FK", referencedColumnName="EMPLOYEE_ID")
	})
	@ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	private Employee employee;
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public JobHistoryId getJobHistoryId() {
		return jobHistoryId;
	}
	public void setJobHistoryId(JobHistoryId jobHistoryId) {
		this.jobHistoryId = jobHistoryId;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
}
