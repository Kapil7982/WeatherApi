package com.weatherForcastApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.weatherForcastApi.service.WeatherService;

import java.io.IOException;

@RestController
public class WeatherController {

    private final WeatherService weatherService;
    
    

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/forecast/summary")
    public String getForecastSummary(@RequestParam String locationName, @RequestHeader("X-Client-ID") String clientId, 
    		@RequestHeader("X-Client-Secret")String clientSecret) throws IOException {
        return weatherService.getForecastSummaryByLocation(locationName);
    }

    @GetMapping("/forecast/hourly/openweathermap")
    public String getHourlyForecastFromOpenWeatherMap(@RequestParam String cityName, @RequestHeader("X-Client-ID") String clientId,
            @RequestHeader("X-Client-Secret") String clientSecret) throws IOException {
        return weatherService.getHourlyForecastByCity(cityName); 
    }
}
