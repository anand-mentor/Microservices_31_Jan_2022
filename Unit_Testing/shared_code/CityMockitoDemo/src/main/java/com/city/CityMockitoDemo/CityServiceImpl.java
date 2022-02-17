package com.city.CityMockitoDemo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CityServiceImpl implements CityService {

	public List<String> findCitiesByCountries(String country) {
		List<String> cities = new ArrayList<String>();
		try {
			Connection dbcon = DBUtils.getDBConnection();
			Statement stmt = dbcon.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM CITIES WHERE country='" + country + "'");
			
			while(rs.next()) {
				cities.add(rs.getString("city"));
			}
		}
		catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		return cities;
	}

}
