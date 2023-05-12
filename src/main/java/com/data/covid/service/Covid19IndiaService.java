package com.data.covid.service;

import java.util.List;

import com.data.covid.responses.CovidRecord;

public interface Covid19IndiaService {
	public List<CovidRecord> getCovidDataByState(List<CovidRecord> rawData, String detectedstate);
}
