package com.sybercare.hospital.adapters.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sybercare.hospital.adapters.entity.DataBeiTai;
import com.sybercare.hospital.adapters.service.BmiService;

@RestController
public class BmiController {
	@Autowired
	private BmiService bmiService;

	@PostMapping("/bmi")
	public String saveBmi(@RequestBody DataBeiTai dataBmi) {
		bmiService.save(dataBmi);
		return "success";
	}
}
