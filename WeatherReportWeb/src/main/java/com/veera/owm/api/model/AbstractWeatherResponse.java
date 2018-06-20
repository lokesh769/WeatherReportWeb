package com.veera.owm.api.model;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.veera.owm.api.gson.SecondsDateTypeAdapter;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class AbstractWeatherResponse {
    @JsonAdapter(SecondsDateTypeAdapter.class)
    @SerializedName("dt")
    private Date dateTime;
    private List<Weather> weather;
}
