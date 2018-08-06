package com.techelevator.nationalPark.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.nationalPark.model.Parks;
import com.techelevator.nationalPark.model.SurveyResult;

@Component
public class SurveyJdbcResultDao implements SurveyResultDao {
	

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
    public SurveyJdbcResultDao(DataSource datasource) {
        this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	
    @Override
    public void saveNewSurvey(SurveyResult surveyToSave) {
    String sqlSaveSurvey = "INSERT INTO survey_result (parkcode, emailaddress, state, activitylevel) VALUES (?,?,?,?)";
    jdbcTemplate.update(sqlSaveSurvey, 
                        surveyToSave.getParkCode(), 
                        surveyToSave.getEmailAddress(), 
                        surveyToSave.getState(), 
                        surveyToSave.getActivityLevel());
    }
	
	@Override
	public List<SurveyResult> getAllSurveys() {
		List <SurveyResult> surveyResults = new ArrayList<>();
		String sqlSurveyResults = "SELECT * FROM survey_result";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSurveyResults);
		while(results.next()) {
			surveyResults.add(mapRowToSurveyResults(results));
		}
		
		return surveyResults;
	}
	
	
	private SurveyResult mapRowToSurveyResults(SqlRowSet results) {
		SurveyResult surveyResults = new SurveyResult();
		Parks park = new Parks();
		surveyResults.setEmailAddress(results.getString("emailaddress"));
		surveyResults.setParkCode(results.getString("parkcode"));
		surveyResults.setState(results.getString("state"));
		surveyResults.setActivityLevel(results.getString("activitylevel"));
		park.setVoteCount(results.getLong("count"));
		return surveyResults;
	}
	
		
//		private Parks mapRowToParks(SqlRowSet results) {
//			Parks park = new Parks();
//			park.setParkCode(results.getString("parkcode"));
//			park.setParkName(results.getString("parkname"));
//			park.setState(results.getString("state"));
//			park.setAcreage(results.getLong("acreage"));
//			park.setElevationInFeet(results.getLong("elevationinfeet"));
//		//	park.setMilesOfTrail(results.getLong("milesoftrail"));
//			park.setNumberOfCampsites(results.getLong("numberofcampsites"));
//			park.setClimate(results.getString("climate"));
//			park.setYearFounded(results.getLong("yearfounded"));
//			park.setAnnualVisitorCount(results.getLong("annualvisitorcount"));
//			park.setInspirationalQuote(results.getString("inspirationalquote"));
//			park.setInspirationalQuoteSource(results.getString("inspirationalquotesource"));;
//			park.setParkDescription(results.getString("parkdescription"));
//			park.setEntryFee(results.getLong("entryfee"));
//			park.setNumberOfAnimalSpecies(results.getLong("numberofanimalspecies"));
//			return park;
//			
//	}
		
	}


