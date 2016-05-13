package com.grsu.entity.parsing;

import com.grsu.entity.Info;
import com.grsu.entity.Weather;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;

import java.io.IOException;
import java.util.List;

/**
 * Example program to list links from a URL.
 */
public class Parser {

    public Parser(){
        super();
    }

    private String[] replaceOvercast(String s){
        s = s.replaceAll("(, )",",");
        String[] mas = s.split(" ");
        for (int i=0; i<mas.length; i++){
            mas[i]=mas[i].replaceAll("[,]", ", ");
        }
        return mas;
    }

    public List<Info> ParsingURL(String year, String month, String day, Weather weather) throws IOException {
        List<Info> infos = new ArrayList<Info>();

        String url = "http://meteo.by/grodno/retro/"+year+"-"+month+"-"+day+"/";

        Info info = new Info();

        Document doc = Jsoup.connect(url).get();
        Elements htmlWeather = doc.select("tr[class=time]");

        String[] typeDay  = htmlWeather.select("td[class=temp]").text().replaceAll("[^A-Za-zА-Яа-яЁё]"," ").replaceAll("[ ]+"," ").split(" ");
        String[] temperature = htmlWeather.select("td[class=temp]").text().replaceAll("[^-+0-9]"," ").replaceAll("[ ]+"," ").split(" ");

        String overStr = htmlWeather.select("td[class=icon]").text();
        String[] overcast = replaceOvercast(overStr);

        String[] pressure = htmlWeather.select("td[class=data]").text().split(" ");
        String[] direction = htmlWeather.select("td[class=dir]").text().split(" ");


        for (int i=0; i<4; i++){
            info.setTypeDay(typeDay[i]);
            info.setTemperature(temperature[2*i+1]+" "+temperature[2*i+2]);
            info.setOvercast(overcast[i]);
            info.setPressure(pressure[3*i]); info.setHumidity(pressure[3*i+1]);info.setSpeed(pressure[3*i+2]);
            info.setDirection(direction[i]);
            info.setWeather(weather);

            infos.add(info);
            info = new Info();
        }


        return infos;
    }

}
