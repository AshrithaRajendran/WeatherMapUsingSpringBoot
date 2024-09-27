package com.jsp.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.weather.response.WeatherResponse;
import com.jsp.weather.services.WeatherService;



@RestController
public class WeatherController 
{
	 @Autowired
	    private WeatherService weatherService;

	    @GetMapping("/weather")
	    public WeatherResponse getWeather(@RequestParam String city) {
	        return weatherService.fetchWeather(city);
	    }
	    
	

}