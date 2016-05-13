package com.grsu.entity;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.util.List;

/**
 * Created by dionp on 11.05.2016.
 */
@Entity
@Table(name = "weather")
public class Weather implements Persistable<Long> {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column
    private String timeDay;

    public Weather(String timeDay) {
        this.timeDay = timeDay;
    }

    public Weather() {
        super();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTimeDay() {
        return timeDay;
    }

    public void setTimeDay(String timeDay) {
        this.timeDay = timeDay;
    }



    @Override
    public Long getId() {
        return null;
    }

    @Override
    public boolean isNew() {
        return false;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "weather", fetch = FetchType.EAGER)
    private List<Info> infos;

    public List<Info> getInfos() {
        return infos;
    }

    public void setInfos(List<Info> infos) {
        this.infos = infos;
    }
}