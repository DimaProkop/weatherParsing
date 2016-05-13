package com.grsu.service.impl;

import com.grsu.entity.Weather;
import com.grsu.repository.WeatherRepository;
import com.grsu.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dionp on 11.05.2016.
 */
@Service
public class WeatherServiceImpl implements WeatherService{

    @Autowired
    private WeatherRepository weatherRepository;

    @Override
    public void addWeather(Weather weather) {
        weatherRepository.saveAndFlush(weather);
    }

    @Override
    public void delete(Long id) {
        weatherRepository.delete(id);
    }

    @Override
    public Weather editWeather(Weather weather) {
        return weatherRepository.saveAndFlush(weather);
    }

    @Override
    public List<Weather> getAll() {
        return weatherRepository.findAll();
    }

    @Override
    public Weather getById(Long id) {
        return weatherRepository.findOne(id);
    }
}
