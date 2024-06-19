package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.DeviceDetails;

public interface DeviceDetailsRepository extends JpaRepository<DeviceDetails, Long> {

}
