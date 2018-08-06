package com.techelevator.nationalPark.model;

public class Parks {
private String parkCode;
private String parkName;
private String state;
private Long acreage;
private Long elevationInFeet;
private Long milesOfTrail;
private Long numberOfCampsites;
private String climate;
private Long yearFounded;
private Long annualVisitorCount;
private String inspirationalQuote;
private String inspirationalQuoteSource;
private String parkDescription;
private Long entryFee;
private Long numberOfAnimalSpecies;
private Long voteCount;


public Long getVoteCount() {
	return voteCount;
}

public void setVoteCount(Long voteCount) {
	this.voteCount = voteCount;
}

public String getParkCode() {
	return parkCode;
}

public String getLowerCaseParkCode() {
		return parkCode.toLowerCase();
}
public void setParkCode(String parkCode) {
	this.parkCode = parkCode;
}
public String getParkName() {
	return parkName;
}
public void setParkName(String parkName) {
	this.parkName = parkName;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public Long getAcreage() {
	return acreage;
}
public void setAcreage(Long acreage) {
	this.acreage = acreage;
}
public Long getElevationInFeet() {
	return elevationInFeet;
}
public void setElevationInFeet(Long elevationInFeet) {
	this.elevationInFeet = elevationInFeet;
}
public Long getMilesOfTrail() {
	return milesOfTrail;
}
public void setMilesOfTrail(Long milesOfTrail) {
	this.milesOfTrail = milesOfTrail;
}
public Long getNumberOfCampsites() {
	return numberOfCampsites;
}
public void setNumberOfCampsites(Long numberOfCampsites) {
	this.numberOfCampsites = numberOfCampsites;
}
public String getClimate() {
	return climate;
}
public void setClimate(String climate) {
	this.climate = climate;
}
public Long getYearFounded() {
	return yearFounded;
}
public void setYearFounded(Long yearFounded) {
	this.yearFounded = yearFounded;
}
public Long getAnnualVisitorCount() {
	return annualVisitorCount;
}
public void setAnnualVisitorCount(Long annualVisitorCount) {
	this.annualVisitorCount = annualVisitorCount;
}
public String getInspirationalQuote() {
	return inspirationalQuote;
}
public void setInspirationalQuote(String inspirationalQuote) {
	this.inspirationalQuote = inspirationalQuote;
}
public String getInspirationalQuoteSource() {
	return inspirationalQuoteSource;
}
public void setInspirationalQuoteSource(String inspirationalQuoteSource) {
	this.inspirationalQuoteSource = inspirationalQuoteSource;
}
public String getParkDescription() {
	return parkDescription;
}
public void setParkDescription(String parkDescription) {
	this.parkDescription = parkDescription;
}
public Long getEntryFee() {
	return entryFee;
}
public void setEntryFee(Long entryFee) {
	this.entryFee = entryFee;
}
public Long getNumberOfAnimalSpecies() {
	return numberOfAnimalSpecies;
}
public void setNumberOfAnimalSpecies(Long numberOfAnimalSpecies) {
	this.numberOfAnimalSpecies = numberOfAnimalSpecies;
}



}
