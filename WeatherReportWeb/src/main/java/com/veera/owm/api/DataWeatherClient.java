package com.veera.owm.api;

import com.veera.owm.api.model.currentWeather.CurrentWeather;
import com.veera.owm.api.query.currentWeather.CurrentWeatherOneLocationQuery;

public interface DataWeatherClient extends WeatherClient {

    CurrentWeather getCurrentWeather(CurrentWeatherOneLocationQuery query);
}
