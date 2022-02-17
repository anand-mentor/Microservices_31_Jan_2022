package com.city.CityMockitoDemo;

import java.util.Arrays;
import java.util.List;

public class CityServiceStub implements CityService {

	@Override
	public List<String> findCitiesByCountries(String country) {
		if(country.equalsIgnoreCase("INDIA")) {
			return Arrays.asList("Delhi", "Mumbai", "Kolkatta", "Chennai");
		}
		else if(country.equalsIgnoreCase("USA")) {
			return Arrays.asList("New York", "Washington");
		}
		return null;
	}

}
