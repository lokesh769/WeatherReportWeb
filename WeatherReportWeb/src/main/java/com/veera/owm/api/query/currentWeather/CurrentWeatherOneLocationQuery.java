package com.veera.owm.api.query.currentWeather;

import com.veera.owm.api.query.QueryWithResponseFormat;

public interface CurrentWeatherOneLocationQuery extends QueryWithResponseFormat {
    String SEARCH_PATH = "/weather";
}
