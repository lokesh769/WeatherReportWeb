package com.veera.owm.api.query;

public interface QueryWithResponseFormat extends Query {
    ResponseFormat getResponseFormat();
    void setResponseFormat(ResponseFormat responseFormat);
}
