package com.veera.owm.api;

import com.veera.owm.api.query.Query;

public interface WeatherClient {
    String getWeatherData(Query query);
}
