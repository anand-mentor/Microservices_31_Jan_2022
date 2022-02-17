package com.city.CityMockitoDemo;

import java.util.List;

public interface CityService {
	List<String> findCitiesByCountries(String country);
}
