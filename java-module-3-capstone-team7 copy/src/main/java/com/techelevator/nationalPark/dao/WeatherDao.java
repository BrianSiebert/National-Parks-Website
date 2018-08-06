package com.techelevator.nationalPark.dao;

import java.util.List;

import com.techelevator.nationalPark.model.Weather;

public interface WeatherDao {

	List<Weather> getTodaysWeather(String parkCode);
	
	List<Weather> getFutureWeather(String parkCode);

}