package com.techelevator.nationalPark.dao;

import java.util.List;

import com.techelevator.nationalPark.model.Parks;

public interface ParkDao {

	List<Parks> getAllParks();
	
	public List<Parks> parkVoteSurveyResults();
	
}
