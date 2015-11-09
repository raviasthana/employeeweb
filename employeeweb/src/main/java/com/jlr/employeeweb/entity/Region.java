package com.jlr.employeeweb.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="REGIONS")
public class Region implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="REGION_ID")
	private long regionId;
	@Column(name="REGION_NAME")
	private String regionName;
	
	@OneToMany(mappedBy="region")
	private Set<Country> countries = new HashSet<>();
	
	public Set<Country> getCountries() {
		return countries;
	}
	public void setCountries(Set<Country> countries) {
		this.countries = countries;
	}
	public long getRegionId() {
		return regionId;
	}
	public void setRegionId(long regionId) {
		this.regionId = regionId;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
}
