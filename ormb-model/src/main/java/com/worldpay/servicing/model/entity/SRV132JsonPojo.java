
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
    "settlementGroupList"
})

public class SRV132JsonPojo {

    @JsonProperty("callInfo")
    private CallInfo callInfo;
    @JsonProperty("settlementGroupList")
    private SettlementGroupList settlementGroupList;
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

    public SRV132JsonPojo withCallInfo(CallInfo callInfo) {
        this.callInfo = callInfo;
        return this;
    }

    @JsonProperty("settlementGroupList")
    public SettlementGroupList getSettlementGroupList() {
        return settlementGroupList;
    }

    @JsonProperty("settlementGroupList")
    public void setSettlementGroupList(SettlementGroupList settlementGroupList) {
        this.settlementGroupList = settlementGroupList;
    }

    public SRV132JsonPojo withSettlementGroupList(SettlementGroupList settlementGroupList) {
        this.settlementGroupList = settlementGroupList;
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

    public SRV132JsonPojo withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    
}
