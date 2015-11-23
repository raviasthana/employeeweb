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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="COUNTRIES")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@countryId")
public class Country implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="COUNTRY_ID")
	private String countryId;
	@Column(name="COUNTRY_NAME")
	private String countryName;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="REGION_ID", nullable=true)
	private Region region;
	
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}	
	public Region getRegion() {
		return region;
	}	
	public void setRegion(Region region) {
		this.region = region;
	}
}
