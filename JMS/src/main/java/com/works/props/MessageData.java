package com.works.props;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class MessageData {

    @SerializedName("service")
    @Expose
    private String service;
    @SerializedName("result")
    @Expose
    private Result result;

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

}