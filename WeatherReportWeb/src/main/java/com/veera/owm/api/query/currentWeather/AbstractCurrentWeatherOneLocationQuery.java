package com.veera.owm.api.query.currentWeather;

import com.veera.owm.api.query.AbstractQueryWithResponseFormat;

public abstract class AbstractCurrentWeatherOneLocationQuery
        extends AbstractQueryWithResponseFormat
        implements CurrentWeatherOneLocationQuery {
    @Override
    protected String getSearchPath() {
        return CurrentWeatherOneLocationQuery.SEARCH_PATH;
    }
}