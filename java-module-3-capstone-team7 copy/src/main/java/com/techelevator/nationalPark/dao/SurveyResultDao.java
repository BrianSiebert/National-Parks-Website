package com.techelevator.nationalPark.dao;

import java.util.List;

import com.techelevator.nationalPark.model.SurveyResult;

public interface SurveyResultDao {

	public List<SurveyResult> getAllSurveys();
	
	public void saveNewSurvey(SurveyResult surveyToSave);
	
}
