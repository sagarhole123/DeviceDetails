package com.example.controller;

import java.util.Base64;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.DeviceDetails;
import com.example.model.SignatureResponse;
import com.example.repository.DeviceDetailsRepository;

@RestController
public class DeviceDetailsController {

	@Autowired
	private DeviceDetailsRepository deviceDetailsRepository;

	@PostMapping("/submit")
	public ResponseEntity<String> submitData(@RequestParam String deviceSerialNumber, @RequestParam String postNumber) {
		DeviceDetails data = new DeviceDetails();
		data.setDeviceSerialNumber(deviceSerialNumber);
		data.setPostNumber(postNumber);
		deviceDetailsRepository.save(data);
		return ResponseEntity.ok("Data submitted successfully!");
	}

	@PostMapping("/downloadSignature")
	public ResponseEntity<SignatureResponse> downloadSignature(@Valid @RequestBody DeviceDetails data) {
		String signature = Base64.getEncoder()
				.encodeToString((data.getDeviceSerialNumber() + data.getPostNumber()).getBytes());
		return ResponseEntity.ok(new SignatureResponse(signature));
	}

}
