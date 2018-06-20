package com.veera.owm.api.model;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.veera.owm.api.gson.SecondsDateTypeAdapter;
import lombok.Data;

import java.util.Date;

@Data
public class SystemParameters {
    @SerializedName("type")
    private String type;
    @SerializedName("id")
    private String id;
    @SerializedName("message")
    private String message;
    @SerializedName("country")
    private String country;
    @JsonAdapter(SecondsDateTypeAdapter.class)
    @SerializedName("sunrise")
    private Date sunrise;
    @JsonAdapter(SecondsDateTypeAdapter.class)
    @SerializedName("sunset")
    private Date sunset;
}
