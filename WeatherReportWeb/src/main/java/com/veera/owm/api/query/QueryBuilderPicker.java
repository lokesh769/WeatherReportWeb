package com.veera.owm.api.query;

import com.veera.owm.api.query.currentWeather.ByCityNameBuilder;

public class QueryBuilderPicker {
    private static QueryBuilderPicker instance;

    private QueryBuilderPicker() {
        //
    }

    public static QueryBuilderPicker pick() {
        if (instance == null) {
            instance = new QueryBuilderPicker();
        }
        return instance;
    }

    public CurrentWeatherPicker currentWeather() {
        return new CurrentWeatherPicker();
    }

    public static class CurrentWeatherPicker {
        public CurrentWeatherOneLocationQueryPicker oneLocation() {
            return new CurrentWeatherOneLocationQueryPicker();
        }

        public static class CurrentWeatherOneLocationQueryPicker {

            public ByCityNameBuilder byCityName(String cityName) {
                return new ByCityNameBuilder(cityName);
            }

        }
    }

}
