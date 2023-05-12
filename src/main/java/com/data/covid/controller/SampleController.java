package com.data.covid.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class SampleController {

	@GetMapping("/health")
	public String getHealth() {
		return "Working fine";
	}
}
