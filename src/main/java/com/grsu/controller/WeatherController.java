package com.grsu.controller;

import com.grsu.entity.Info;
import com.grsu.entity.Weather;
import com.grsu.entity.parsing.Parser;
import com.grsu.service.InfoService;
import com.grsu.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

/**
 * Created by dionp on 11.05.2016.
 */
@Controller
@RequestMapping("/weather")
public class WeatherController {


    @Autowired
    WeatherService weatherService;
    @Autowired
    InfoService infoService;

    @RequestMapping(value = "/list/", method = RequestMethod.POST)
    public ModelAndView listWeathers(@RequestParam("year") String year,
                                   @RequestParam("month") String month,
                                   @RequestParam("day") String day) {

        ModelAndView modelAndView = new ModelAndView("info");

        List<Weather> weatherList = weatherService.getAll();

        String Date = year + "-" + ((month.length()<2)? "0" + month: month) + "-" + ((day.length()<2)? "0" + day: day);

            for (Weather weather : weatherList) {
                if (weather.getTimeDay().split(" ")[0].equals(Date)) {
                    modelAndView.addObject("answers", weather.getInfos());
                    return modelAndView;
                }
            }

        Weather newWeather = new Weather();
        newWeather.setTimeDay(Date);





            Parser parser = new Parser();
            try {
                List<Info> infoList = parser.ParsingURL(year, month, day, newWeather);

                newWeather.setInfos(infoList);

                weatherService.addWeather(newWeather);



                //list on info.jsp
                modelAndView.addObject("answers", infoList);

            } catch (IOException e) {
                e.printStackTrace();
            }






        return modelAndView;
    }

}
