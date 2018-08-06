package com.techelevator.npgeek;



import javax.servlet.http.HttpSession;

import org.apache.bcel.generic.RETURN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.nationalPark.dao.ParkDao;
import com.techelevator.nationalPark.dao.WeatherDao;
import com.techelevator.nationalPark.model.Parks;

@Controller
public class ParkViewController {
	
	@Autowired
	private ParkDao parkDao;
	@Autowired
	private WeatherDao weatherDao;
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String getAllParks(ModelMap modelHolder) {
		modelHolder.put("parks", parkDao.getAllParks());
		return "homePage";
	}
	
	@RequestMapping(path="/parkdetails", method=RequestMethod.GET)
	public String getParkDetails(ModelMap modelHolder, @RequestParam String parkCode) {
		for(Parks parks : parkDao.getAllParks()) {
			if(parks.getParkCode().equals(parkCode)) {
				modelHolder.put("parks", parks);
				modelHolder.put("weather", weatherDao.getTodaysWeather(parkCode));
				modelHolder.put("futureWeather", weatherDao.getFutureWeather(parkCode));
			}
		}
		return "parkOverview";
	}
	
	@RequestMapping(path="/parkdetails", method=RequestMethod.POST)
	public String chooseTempFormat(@RequestParam String parkCode, HttpSession session, @RequestParam Boolean isCelsius) {
		session.setAttribute("isCelsius", isCelsius);
	
		return "redirect:/parkdetails?parkCode=" + parkCode;
	}
	
}
