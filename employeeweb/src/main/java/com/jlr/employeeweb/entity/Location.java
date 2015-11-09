package com.jlr.employeeweb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="LOCATIONS")
public class Location implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="LOCATION_ID")
	private long locationId;
	@Column(name="STREET_ADDRESS")
	private String streetAddress;
	@Column(name="POSTAL_CODE")
	private String postCode;
	@Column(name="CITY")
	private String city;
	@Column(name="STATE_PROVINCE")
	private String stateProvince;
	
	@OneToOne
	@JoinColumn(name="COUNTRY_ID", nullable=true)
	private Country country;
	
	public long getLocationId() {
		return locationId;
	}
	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStateProvince() {
		return stateProvince;
	}
	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
}
