
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
    "openBills"
})

public class SRV131JsonPojo {

    @JsonProperty("callInfo")
    private CallInfo callInfo;
    @JsonProperty("openBills")
    private OpenBills openBills;
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

    public SRV131JsonPojo withCallInfo(CallInfo callInfo) {
        this.callInfo = callInfo;
        return this;
    }

    @JsonProperty("openBills")
    public OpenBills getOpenBills() {
        return openBills;
    }

    @JsonProperty("openBills")
    public void setOpenBills(OpenBills openBills) {
        this.openBills = openBills;
    }

    public SRV131JsonPojo withOpenBills(OpenBills openBills) {
        this.openBills = openBills;
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

    public SRV131JsonPojo withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

   

}
