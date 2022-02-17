package com.city.CityMockitoDemo;

import java.util.List;

public class BusinessApp {
	CityService cityService;
	
	public BusinessApp(CityService cityService) {
		this.cityService = cityService;
	}
	
	public List<String> retrieveCityListByCountry(String country) {
		List<String> cities =  this.cityService.findCitiesByCountries(country);
		return cities;
	}
}
