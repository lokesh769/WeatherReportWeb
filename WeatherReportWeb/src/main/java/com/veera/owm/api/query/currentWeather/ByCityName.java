package com.veera.owm.api.query.currentWeather;

import com.veera.owm.api.query.QueryRequestPartBuilder;
import com.veera.owm.api.query.Type;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ByCityName extends AbstractCurrentWeatherOneLocationQuery {
    private final String cityName;
    private String countryCode;
    private Type type;

    public ByCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    protected String getRequestPart() {
        return QueryRequestPartBuilder.byCityName(getCityName(), getCountryCode(), getType());
    }
}
