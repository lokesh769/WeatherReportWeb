package com.veera.owm.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.veera.owm.api.gson.WindDirectionDeserializer;
import com.veera.owm.api.gson.WindDirectionSerializer;
import com.veera.owm.api.model.WindDirection;
import com.veera.owm.api.model.currentWeather.CurrentWeather;
import com.veera.owm.api.query.Query;
import com.veera.owm.api.query.QueryWithResponseFormat;
import com.veera.owm.api.query.ResponseFormat;
import com.veera.owm.api.query.currentWeather.CurrentWeatherOneLocationQuery;

import java.lang.reflect.Type;

public abstract class AbstractDataWeatherClient implements DataWeatherClient {

    @Override
    public String getWeatherData(Query query) {
        return makeRequest(query);
    }


    @Override
    public CurrentWeather getCurrentWeather(CurrentWeatherOneLocationQuery query) {
        CurrentWeather result = getResult(query, CurrentWeather.TYPE);
        return result;
    }

    protected abstract String makeRequest(Query query);

    private <T> T getResult(QueryWithResponseFormat query, Type type) {
        ResponseFormat responseFormat = query.getResponseFormat();
        if (responseFormat == null || responseFormat == ResponseFormat.JSON) {
            return getResult((Query) query, type);
        }
        return null;
    }

    private <T> T getResult(Query query, Type type) {
        String data = getWeatherData(query);
        final T result = gson().fromJson(data, type);
        return result;
    }

    protected static Gson gson() {
        return GsonHolder.INSTANCE.value;
    }

    protected static JsonParser jsonParser() {
        return JsonParserHolder.INSTANCE.value;
    }

    private enum JsonParserHolder {
        INSTANCE;

        @SuppressWarnings({"NonSerializableFieldInSerializableClass", "ImmutableEnumChecker"})
        private final JsonParser value = new JsonParser();

    }

    private enum GsonHolder {
        INSTANCE;
        @SuppressWarnings({"NonSerializableFieldInSerializableClass", "ImmutableEnumChecker"})
        private final Gson value = new GsonBuilder()
                .registerTypeAdapter(WindDirection.class, new WindDirectionDeserializer())
                .registerTypeAdapter(WindDirection.class, new WindDirectionSerializer())
                .create();
    }
}
