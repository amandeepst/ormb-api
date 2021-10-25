
package com.worldpay.servicing.model.entity;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "callId",
    "callType",
    "description",
    "creationDate"
})
public class CallInfo {

    @JsonProperty("callId")
    private String callId;
    @JsonProperty("callType")
    private String callType;
    @JsonProperty("description")
    private String description;
    @JsonProperty("creationDate")
    private String creationDate;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("callId")
    public String getCallId() {
        return callId;
    }

    @JsonProperty("callId")
    public void setCallId(String callId) {
        this.callId = callId;
    }

    public CallInfo withCallId(String callId) {
        this.callId = callId;
        return this;
    }

    @JsonProperty("callType")
    public String getCallType() {
        return callType;
    }

    @JsonProperty("callType")
    public void setCallType(String callType) {
        this.callType = callType;
    }

    public CallInfo withCallType(String callType) {
        this.callType = callType;
        return this;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public CallInfo withDescription(String description) {
        this.description = description;
        return this;
    }

    @JsonProperty("creationDate")
    public String getCreationDate() {
        return creationDate;
    }

    @JsonProperty("creationDate")
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public CallInfo withCreationDate(String creationDate) {
        this.creationDate = creationDate;
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

}
