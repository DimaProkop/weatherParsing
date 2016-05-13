package com.grsu.repository;

import com.grsu.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by dionp on 11.05.2016.
 */
public interface WeatherRepository extends JpaRepository<Weather, Long> {
}
