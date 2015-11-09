package com.jlr.employeeweb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmployeeId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="EMPLOYEE_ID")
	private long employeeId;

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	
	//Component type used as identifier must implement equals() and hashCode()
	
	@Override
	public boolean equals(Object obj) {
		if(obj == this) return true;
		if(!(obj instanceof EmployeeId)) return false;
		
		return (((EmployeeId)obj).getEmployeeId() == this.employeeId);
	}
	
	@Override
	public int hashCode() {
		int hashCode = 17;
		hashCode = hashCode * 31 + new Long(employeeId).hashCode();
		return hashCode;
	}
}
