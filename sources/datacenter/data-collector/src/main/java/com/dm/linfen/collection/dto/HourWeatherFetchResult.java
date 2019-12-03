package com.dm.linfen.collection.dto;

import lombok.Data;

import java.util.List;

@Data
public class HourWeatherFetchResult {
	private String station;
	private String name;
	private List<HourWeatherFetchDto> data;
}
