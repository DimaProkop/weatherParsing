package com.grsu.service;

import com.grsu.entity.Weather;

import java.util.List;

/**
 * Created by dionp on 11.05.2016.
 */
public interface WeatherService {
    void addWeather(Weather weather);
    void delete(Long id);
    Weather editWeather(Weather weather);
    List<Weather> getAll();
    Weather getById(Long id);
}
