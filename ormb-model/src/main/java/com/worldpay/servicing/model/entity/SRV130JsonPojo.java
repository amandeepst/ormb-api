
package com.worldpay.servicing.model.entity;

import java.util.HashMap;
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
    "balance"
})

public class SRV130JsonPojo {

    @JsonProperty("callInfo")
    private CallInfo callInfo;
    @JsonProperty("balance")
    private Balance balance;
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

    public SRV130JsonPojo withCallInfo(CallInfo callInfo) {
        this.callInfo = callInfo;
        return this;
    }

    @JsonProperty("balance")
    public Balance getBalance() {
        return balance;
    }

    @JsonProperty("balance")
    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public SRV130JsonPojo withBalance(Balance balance) {
        this.balance = balance;
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

    public SRV130JsonPojo withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    

}
