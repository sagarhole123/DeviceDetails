package com.example.model;

import javax.validation.constraints.NotEmpty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DeviceDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Device Serial Number is required")
	private String deviceSerialNumber;

	@NotEmpty(message = "Post Number is required")
	private String postNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDeviceSerialNumber() {
		return deviceSerialNumber;
	}

	public void setDeviceSerialNumber(String deviceSerialNumber) {
		this.deviceSerialNumber = deviceSerialNumber;
	}

	public String getPostNumber() {
		return postNumber;
	}

	public void setPostNumber(String postNumber) {
		this.postNumber = postNumber;
	}

	@Override
	public String toString() {
		return "DeviceDetails{" + "id=" + id + ", deviceSerialNumber='" + deviceSerialNumber + '\'' + ", postNumber='"
				+ postNumber + '\'' + '}';
	}
}
