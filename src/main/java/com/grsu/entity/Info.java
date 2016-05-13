package com.grsu.entity;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;

/**
 * Created by dionp on 11.05.2016.
 */

@Entity
@Table(name = "info")
public class Info implements Persistable<Long> {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column
    private String temperature;

    @Column
    private String overcast;

    @Column
    private String humidity;

    @Column
    private String speed;

    @Column
    private String direction;

    @Column
    private String pressure;

    @Column
    private String typeDay;

    public String getPressure() {
        return pressure;
    }

    public Info(String temperature, String overcast, String humidity, String speed, String direction, String pressure, String typeDay) {

        this.temperature = temperature;
        this.overcast = overcast;
        this.humidity = humidity;
        this.speed = speed;
        this.direction = direction;
        this.pressure = pressure;
        this.typeDay = typeDay;
    }

    public String getTypeDay() {
        return typeDay;
    }

    public void setTypeDay(String typeDay) {
        this.typeDay = typeDay;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public Info() {
        super();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getOvercast() {
        return overcast;
    }

    public void setOvercast(String overcast) {
        this.overcast = overcast;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public boolean isNew() {
        return false;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    private Weather weather;

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }
}
