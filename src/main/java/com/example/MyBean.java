package com.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyBean {

	private final JdbcTemplate jdbcTemplate;
	org.hsqldb.StatementInsert hh;org.hsqldb.jdbc.JDBCStatement gg;
    @Autowired
    public MyBean(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @GetMapping("/locationdetails/{ip}")
    public Object findLocationByIp(@PathVariable("ip") String ip){
    	return jdbcTemplate.query("select  * from ip2location where inet_aton("+ip+") <= ip_to limit 1" , new Ip2LocationMapper());
    }

    
    
    public class Ip2LocationMapper implements RowMapper<Ip2Location> {
    	   public Ip2Location mapRow(ResultSet rs, int rowNum) throws SQLException {
    		   Ip2Location ip2Location = new Ip2Location();
    		   ip2Location.setIpFrom(rs.getInt("ip_from"));
    		   ip2Location.setIpTo(rs.getInt("ip_to"));
    		   ip2Location.setCountryCode(rs.getString("country_code"));
    		   ip2Location.setRegionName(rs.getString("region_name"));
    		   ip2Location.setCityName(rs.getString("city_name"));
    		   ip2Location.setLatitude(rs.getDouble("latitude"));
    		   ip2Location.setLongitude(rs.getDouble("longitude"));
    		   ip2Location.setZipCode(rs.getString("zip_code"));
    		   ip2Location.setTimeZone(rs.getString("time_zone"));
    		   
    	      return ip2Location;
    	   }
    }
    public class Ip2Location {
    	
    	Integer ipFrom;
    	Integer ipTo;
    	String  countryCode;
    	String countryName;
    	String regionName;
    	String cityName;
    	Double latitude;
    	Double longitude;
    	String zipCode;
    	String timeZone;
		public Ip2Location() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Ip2Location(Integer ipFrom, Integer ipTo, String countryCode, String countryName, String regionName,
				String cityName, Double latitude, Double longitude, String zipCode, String timeZone) {
			super();
			this.ipFrom = ipFrom;
			this.ipTo = ipTo;
			this.countryCode = countryCode;
			this.countryName = countryName;
			this.regionName = regionName;
			this.cityName = cityName;
			this.latitude = latitude;
			this.longitude = longitude;
			this.zipCode = zipCode;
			this.timeZone = timeZone;
		}
		public Integer getIpFrom() {
			return ipFrom;
		}
		public void setIpFrom(Integer ipFrom) {
			this.ipFrom = ipFrom;
		}
		public Integer getIpTo() {
			return ipTo;
		}
		public void setIpTo(Integer ipTo) {
			this.ipTo = ipTo;
		}
		public String getCountryCode() {
			return countryCode;
		}
		public void setCountryCode(String countryCode) {
			this.countryCode = countryCode;
		}
		public String getCountryName() {
			return countryName;
		}
		public void setCountryName(String countryName) {
			this.countryName = countryName;
		}
		public String getRegionName() {
			return regionName;
		}
		public void setRegionName(String regionName) {
			this.regionName = regionName;
		}
		public String getCityName() {
			return cityName;
		}
		public void setCityName(String cityName) {
			this.cityName = cityName;
		}
		public Double getLatitude() {
			return latitude;
		}
		public void setLatitude(Double latitude) {
			this.latitude = latitude;
		}
		public Double getLongitude() {
			return longitude;
		}
		public void setLongitude(Double longitude) {
			this.longitude = longitude;
		}
		public String getZipCode() {
			return zipCode;
		}
		public void setZipCode(String zipCode) {
			this.zipCode = zipCode;
		}
		public String getTimeZone() {
			return timeZone;
		}
		public void setTimeZone(String timeZone) {
			this.timeZone = timeZone;
		}
    	
    	
    	
    }
}
