package com.techelevator.nationalPark.dao;


import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.nationalPark.model.Parks;
import com.techelevator.nationalPark.model.SurveyResult;

@Component
public class ParkJdbcDao implements ParkDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
    public ParkJdbcDao(DataSource datasource) {
        this.jdbcTemplate = new JdbcTemplate(datasource);

}
	@Override
	public List<Parks> getAllParks() {
		List<Parks> parks = new ArrayList<>();
        String allProjectSql = "SELECT * FROM park";
        SqlRowSet results = jdbcTemplate.queryForRowSet(allProjectSql);
        while(results.next()) {
            parks.add(mapRowToParks(results));
        }
        return parks;
	}
	
    @Override
    public List<Parks> parkVoteSurveyResults() {
		List<Parks> surveyVotes = new ArrayList<>();
		String sqlSurveyVotes = "SELECT park.*, count(survey_result.parkcode) FROM survey_result JOIN park ON park.parkcode = survey_result.parkcode GROUP BY park.parkcode ORDER BY count DESC LIMIT 5";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSurveyVotes);
		while(results.next()) {
			surveyVotes.add(mapRowForResults(results));
		}
		return surveyVotes;
    }
    
	private Parks mapRowToParks(SqlRowSet results) {
		Parks park = new Parks();
		park.setParkCode(results.getString("parkcode"));
		park.setParkName(results.getString("parkname"));
		park.setState(results.getString("state"));
		park.setAcreage(results.getLong("acreage"));
		park.setElevationInFeet(results.getLong("elevationinfeet"));
	//	park.setMilesOfTrail(results.getLong("milesoftrail"));
		park.setNumberOfCampsites(results.getLong("numberofcampsites"));
		park.setClimate(results.getString("climate"));
		park.setYearFounded(results.getLong("yearfounded"));
		park.setAnnualVisitorCount(results.getLong("annualvisitorcount"));
		park.setInspirationalQuote(results.getString("inspirationalquote"));
		park.setInspirationalQuoteSource(results.getString("inspirationalquotesource"));;
		park.setParkDescription(results.getString("parkdescription"));
		park.setEntryFee(results.getLong("entryfee"));
		park.setNumberOfAnimalSpecies(results.getLong("numberofanimalspecies"));
		return park;
	}
		
		private Parks mapRowForResults(SqlRowSet results) {
			Parks park = new Parks();
			park.setParkCode(results.getString("parkcode"));
			park.setParkName(results.getString("parkname"));
			park.setParkDescription(results.getString("parkdescription"));
			park.setState(results.getString("state"));
			park.setVoteCount(results.getLong("count"));
			return park;
}
}
