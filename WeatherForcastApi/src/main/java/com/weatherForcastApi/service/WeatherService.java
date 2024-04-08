package com.weatherForcastApi.service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.UUID;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeatherService {

    private final OkHttpClient okHttpClient;

    @Value("${rapidapi.key}")
    private String rapidApiKey;

    @Value("${rapidapi.host}")
    private String rapidApiHost;
    
    @Value("${openweathermap.api.key}")
    private String openWeatherMapApiKey;
    
    private final String clientId = UUID.randomUUID().toString();
    private final String clientSecret = UUID.randomUUID().toString();

    public WeatherService(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
        this.rapidApiKey = "Paste_your_rapid_api_key"; 
        this.rapidApiHost = "Paste_your_rapid_api_host";
        this.openWeatherMapApiKey = "Paste_your_open_weather_map_api_key";
    }

    public String getForecastSummaryByLocation(String locationName) throws IOException,IllegalArgumentException  {
    	if (locationName == null || locationName.trim().isEmpty()) {
            throw new IllegalArgumentException("Location name cannot be null or empty.");
        }
        Request request = new Request.Builder()
                .url("https://forecast9.p.rapidapi.com/rapidapi/forecast/" + locationName + "/summary/")
                .get()
                .addHeader("X-RapidAPI-Key", rapidApiKey)
                .addHeader("X-RapidAPI-Host", rapidApiHost)
                .addHeader("X-Client-ID", clientId)
                .addHeader("X-Client-Secret", clientSecret)
                .build();

        try (Response response = okHttpClient.newCall(request).execute()) {
            return response.body().string();
        }
        catch (IOException e) {
            e.printStackTrace();
            return "An error occurred while fetching forecast summary for location: " + e.getMessage();
        }
    }

    public String getHourlyForecastByCity(String cityName) throws IOException, IllegalArgumentException {
    	if (cityName == null || cityName.trim().isEmpty()) {
            throw new IllegalArgumentException("City name cannot be null or empty.");
        }
        String url = "http://api.openweathermap.org/data/2.5/forecast?q=" + cityName + "&appid=" + openWeatherMapApiKey;
        Request request = new Request.Builder()
                .url(url)
                .header("X-Client-ID", clientId)
                .header("X-Client-Secret", clientSecret)
                .get()
                .build();

        try (Response response = okHttpClient.newCall(request).execute()) {
            return response.body().string();
        }
        catch (IOException e) {
            e.printStackTrace();
            return "An error occurred while fetching hourly forecast for city: " + e.getMessage();
        }
    }

}
