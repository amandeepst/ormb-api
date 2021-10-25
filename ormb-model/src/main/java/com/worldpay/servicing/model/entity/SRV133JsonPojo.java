
package com.worldpay.servicing.model.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "callInfo",
    "priceList"
})

public class SRV133JsonPojo {

    @JsonProperty("callInfo")
    private CallInfo callInfo;
    @JsonProperty("priceList")
    private List<SRV133> priceList = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("callInfo")
    public CallInfo getCallInfo() {
        return callInfo;
    }

    @JsonProperty("callInfo")
    public void setCallInfo(CallInfo callInfo) {
        this.callInfo = callInfo;
    }

    public SRV133JsonPojo withCallInfo(CallInfo callInfo) {
        this.callInfo = callInfo;
        return this;
    }

    @JsonProperty("priceList")
    public List<SRV133> getPriceList() {
        return priceList;
    }

    @JsonProperty("priceList")
    public void setPriceList(List<SRV133> srv133List) {
        this.priceList = srv133List;
    }

    public SRV133JsonPojo withPriceList(List<SRV133> priceList) {
        this.priceList = priceList;
        return this;
    }


    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public SRV133JsonPojo withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    

}
