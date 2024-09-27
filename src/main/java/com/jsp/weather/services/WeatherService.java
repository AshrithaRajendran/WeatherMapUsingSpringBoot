package com.jsp.weather.services;



import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jsp.weather.response.OpenWeatherMapResponse;
import com.jsp.weather.response.WeatherResponse;



@Service
public class WeatherService 
{
	 private final String API_KEY ="9a2624477e2f4c531dfa5b6ac01220e3"; // Replace with your API key
	    private final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric";

	    public WeatherResponse fetchWeather(String city) {
	        String url = String.format(BASE_URL, city, API_KEY);
	        RestTemplate restTemplate = new RestTemplate();
	        OpenWeatherMapResponse response = restTemplate.getForObject(url, OpenWeatherMapResponse.class);

	        WeatherResponse weatherResponse = new WeatherResponse();
	        weatherResponse.setCity(response.getName());
	        weatherResponse.setDescription(response.getWeather()[0].getDescription());
	        weatherResponse.setTemperature(response.getMain().getTemp());

	        return weatherResponse;
	    }

}