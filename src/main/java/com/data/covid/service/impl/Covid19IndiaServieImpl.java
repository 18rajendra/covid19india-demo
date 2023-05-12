package com.data.covid.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.data.covid.responses.CovidRecord;
import com.data.covid.service.Covid19IndiaService;

@Service
public class Covid19IndiaServieImpl implements Covid19IndiaService {

	@Override
	public List<CovidRecord> getCovidDataByState(List<CovidRecord> rawData, String detectedstate) {
		List<CovidRecord> filteredData=rawData.stream()
				.filter(p->p.getDetectedstate().equals(detectedstate))
				.collect(Collectors.toList());
		return filteredData;
	}

}
