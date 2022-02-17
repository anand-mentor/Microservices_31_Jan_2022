package com.city.CityMockitoDemo;

import static org.junit.Assert.*;

import org.junit.Test;

public class BusinessAppTest {

	@Test
	public void test() {
		CityService cityService = new CityServiceStub();
		BusinessApp businessApp = new BusinessApp(cityService);
		assertEquals(2, businessApp.retrieveCityListByCountry("USA").size());
	}

}
