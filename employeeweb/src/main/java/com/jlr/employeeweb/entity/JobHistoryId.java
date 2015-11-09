package com.jlr.employeeweb.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class JobHistoryId implements Serializable{
	
	private static final long serialVersionUID = 9032013554542262690L;

	private EmployeeId employeeId;

	@Temporal(TemporalType.DATE)
	@Column(name="START_DATE")
	private Date startDate;
	
	public EmployeeId getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(EmployeeId employeeId) {
		this.employeeId = employeeId;
	}

	public Date getStartDate() {
		return (Date)startDate.clone();
	}

	public void setStartDate(Date startDate) {
		this.startDate = (Date)startDate.clone();
	}
	
	//Component type used as identifier must implement equals() and hashCode()
	
	@Override
	public boolean equals(Object obj){
		if(obj == this) return true;
		if(!(obj instanceof JobHistoryId)) return false;
		JobHistoryId jhId = (JobHistoryId)obj;
		return jhId.getEmployeeId().equals(this.getEmployeeId())
				&& jhId.getStartDate().equals(this.getStartDate());
	}
	
	@Override
	public int hashCode(){
		int hashCode = 17;
		hashCode = hashCode * 31 + employeeId.hashCode();
		hashCode = hashCode * 31 + startDate.hashCode();
		return hashCode;
	}
}
