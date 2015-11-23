package com.jlr.employeeweb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmployeeId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="EMPLOYEE_ID")
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public EmployeeId() {}
	
	public EmployeeId(long id) {
		this.id = id;
	}

	//Component type used as identifier must implement equals() and hashCode()
	
	@Override
	public boolean equals(Object obj) {
		if(obj == this) return true;
		if(!(obj instanceof EmployeeId)) return false;
		
		return (((EmployeeId)obj).getId() == this.id);
	}
	
	@Override
	public int hashCode() {
		int hashCode = 17;
		hashCode = hashCode * 31 + new Long(id).hashCode();
		return hashCode;
	}
}
