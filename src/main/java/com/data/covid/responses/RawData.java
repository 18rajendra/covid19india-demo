package com.data.covid.responses;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class RawData {
	List<CovidRecord> raw_data;

	public List<CovidRecord> getRaw_data() {
		return raw_data;
	}

	public void setRaw_data(List<CovidRecord> raw_data) {
		this.raw_data = raw_data;
	}
	
}
