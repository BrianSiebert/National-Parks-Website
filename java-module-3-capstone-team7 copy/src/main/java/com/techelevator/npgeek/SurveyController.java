package com.techelevator.npgeek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.nationalPark.dao.ParkDao;
import com.techelevator.nationalPark.dao.SurveyResultDao;
import com.techelevator.nationalPark.model.SurveyResult;

@Controller
public class SurveyController {

	@Autowired
	private SurveyResultDao surveyResultDao;
	
	@Autowired 
	private ParkDao parkDao;
	
	@RequestMapping(path="/survey", method=RequestMethod.GET)
	public String showSurveyPage(ModelMap modelHolder) {
		modelHolder.put("parks", parkDao.getAllParks());
		return "survey";
	}
	
	@RequestMapping(path="/survey", method=RequestMethod.POST)
	public String postNewSurvey(@RequestParam String emailAddress, @RequestParam String state, @RequestParam String activityLevel, @RequestParam String parkCode) {
		SurveyResult newSurvey = new SurveyResult();
		newSurvey.setEmailAddress(emailAddress);
		newSurvey.setState(state);
		newSurvey.setActivityLevel(activityLevel);
		newSurvey.setParkCode(parkCode);
		surveyResultDao.saveNewSurvey(newSurvey);
		return "redirect:/surveyresult";
	}
	
	@RequestMapping(path="/surveyresult", method=RequestMethod.GET)
	public String showResultsPage(ModelMap modelHolder) {
		modelHolder.put("parks", parkDao.parkVoteSurveyResults());
		return "surveyresult";
	}

}
