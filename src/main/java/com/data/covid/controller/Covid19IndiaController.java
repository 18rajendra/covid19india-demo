package com.data.covid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.data.covid.responses.CovidRecord;
import com.data.covid.responses.RawData;
import com.data.covid.responses.ResponseModal;
import com.data.covid.service.Covid19IndiaService;

@RestController
@RequestMapping("covid19india")
public class Covid19IndiaController {
	
	@Autowired
	private Covid19IndiaService service;
	
	@GetMapping("/covid-data")
	public ResponseEntity<?> getCovidData() {
		ResponseEntity<?> responseEntity=null;
		ResponseModal modal=new ResponseModal();
		RawData rawData=getCovid19IndiaRawData();
		if(rawData !=null) {
			modal.setMessage("Success");
			modal.setStatusCode(HttpStatus.OK.value());
			modal.setResponseData(rawData);
			responseEntity=new ResponseEntity<>(modal,HttpStatus.OK);
		}else {
			modal.setMessage("Failure");
			modal.setStatusCode(HttpStatus.EXPECTATION_FAILED.value());
			modal.setResponseData(rawData);
			responseEntity=new ResponseEntity<>(modal,HttpStatus.EXPECTATION_FAILED);
		}
		return responseEntity;
		
	}
	
	@GetMapping("/covid-data/{detectedstate}")
	public ResponseEntity<?> getCovidDataByState(@PathVariable(name="detectedstate") String detectedstate) {
		ResponseEntity<?> responseEntity=null;
		ResponseModal modal=new ResponseModal();
		RawData rawData=new RawData();
		List<CovidRecord> records=service.getCovidDataByState(getCovid19IndiaRawData().getRaw_data(),detectedstate);
		
		if(records.size() > 0) {
			rawData.setRaw_data(records);
			modal.setMessage("Success");
			modal.setStatusCode(HttpStatus.OK.value());
			modal.setResponseData(rawData);
			responseEntity=new ResponseEntity<>(modal,HttpStatus.OK);
		}else {
			modal.setMessage("Failure");
			modal.setStatusCode(HttpStatus.EXPECTATION_FAILED.value());
			modal.setResponseData("data not found");
			responseEntity=new ResponseEntity<>(modal,HttpStatus.EXPECTATION_FAILED);
		}
		return responseEntity;
		
	}
	
	public RawData getCovid19IndiaRawData() {
		RestTemplate restTemplate=new RestTemplate();
		return restTemplate.getForObject("https://api.covid19india.org/raw_data6.json", RawData.class);
	}
	

}
