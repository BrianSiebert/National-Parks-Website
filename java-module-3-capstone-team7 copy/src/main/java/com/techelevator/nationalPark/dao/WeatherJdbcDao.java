package com.techelevator.nationalPark.dao;


import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.nationalPark.model.Weather;

@Component
public class WeatherJdbcDao implements WeatherDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public WeatherJdbcDao(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Override
	public List<Weather> getTodaysWeather(String parkCode) {
		List<Weather> Weather = new ArrayList<>();
        String allProjectSql = "SELECT * FROM weather "+
        						  "WHERE parkcode = ? AND fivedayforecastvalue = 1;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(allProjectSql, parkCode);
        while(results.next()) {
            Weather.add(mapRowToWeather(results));
        }
        return Weather;
	}
	
	@Override
	public List<Weather> getFutureWeather(String parkCode) {
		List<Weather> Weather = new ArrayList<>();
        String allProjectSql = "SELECT * FROM weather "+
				  			  "WHERE parkcode = ? AND fivedayforecastvalue BETWEEN 2 AND 5;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(allProjectSql, parkCode);
        while(results.next()) {
            Weather.add(mapRowToWeather(results));
        }
        return Weather;
	}
	private Weather mapRowToWeather(SqlRowSet results) {
		Weather weather = new Weather();
		weather.setParkCode(results.getString("parkcode"));
		weather.setFiveDayForcastValue(results.getLong("fivedayforecastvalue"));
		weather.setLow(results.getLong("low"));
		weather.setHigh(results.getLong("high"));
		weather.setForecast(results.getString("forecast"));
		return weather;
	}
}
