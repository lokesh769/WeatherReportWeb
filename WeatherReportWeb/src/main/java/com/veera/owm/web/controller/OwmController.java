package com.veera.owm.web.controller;

import com.veera.owm.api.DataWeatherClient;
import com.veera.owm.api.UrlConnectionDataWeatherClient;
import com.veera.owm.api.model.Weather;
import com.veera.owm.api.model.currentWeather.CurrentWeather;
import com.veera.owm.api.query.*;
import com.veera.owm.api.query.currentWeather.CurrentWeatherOneLocationQuery;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class OwmController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/currentWeather")
    public String getCurrentWeather(@RequestParam("city") String city, Model model) {

        final String API_KEY = "20e32ced0085abb2bec1616135320b32";
        DataWeatherClient client = new UrlConnectionDataWeatherClient(API_KEY);
        CurrentWeatherOneLocationQuery currentWeatherOneLocationQuery = QueryBuilderPicker.pick()
                .currentWeather()                   // get current weather
                .oneLocation()                      // for one location
                .byCityName(city)                   // for  city
                //.countryCode("UA")                // in country
                .type(Type.ACCURATE)                // with Accurate search
                .language(Language.ENGLISH)         // in English language
                .responseFormat(ResponseFormat.JSON)// with JSON response format
                .unitFormat(UnitFormat.METRIC)      // in metric units
                .build();
        CurrentWeather currentWeather = client.getCurrentWeather(currentWeatherOneLocationQuery);
        model.addAttribute("description", prettyPrint(currentWeather.getWeather()));
        model.addAttribute("prettyPrint", prettyPrint(currentWeather));
        model.addAttribute("weather", currentWeather);
        model.addAttribute("date", currentWeather.getDateTime());
        model.addAttribute("city", String.format("Current weather in %s(%s)", currentWeather.getCityName(), currentWeather.getSystemParameters().getCountry()));
        return "owmReport";
    }

    private static String prettyPrint(CurrentWeather currentWeather) {
        return String.format(
                "&nbsp;&nbsp;Temperature: %.1f &#8451; ( %.1f &#8457; ) <br> " +
                        "&nbsp;&nbsp;Humidity: %.1f %%<br> " +
                        "&nbsp;&nbsp;Pressure: %.1f hPa <br> " +
                        "&nbsp;&nbsp;Wind Speed: %.1f mph<br> " +
                        "&nbsp;&nbsp;Clouds : %.1f %% <br>"
                ,
                currentWeather.getMainParameters().getTemperature(),
                (9 / 5) * currentWeather.getMainParameters().getTemperature() + 32,
                currentWeather.getMainParameters().getHumidity(),
                currentWeather.getMainParameters().getPressure(),
                currentWeather.getWind().getSpeed(),
                currentWeather.getClouds().getAll()
        );
    }

    private static String prettyPrint(List<Weather> weatherList) {
        String description = "";
        for (int i = 0; i < weatherList.size(); i++) {
            Weather weather = weatherList.get(i);
            description = description.concat(weather.getDescription());
            if (i < weatherList.size() - 1) {
                description = description.concat(", ");
            } else {
                description = description.concat(".");
            }
        }

        return description;
    }

}
