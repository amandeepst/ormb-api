
package com.worldpay.servicing.model.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    "partyId",
    "settlementGroup"
})

public class SettlementGroupList {

    @JsonProperty("partyId")
    private String partyId;
    @JsonProperty("settlementGroup")
    private List<SRV132> settlementGroup = new ArrayList<SRV132>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("partyId")
    public String getPartyId() {
        return partyId;
    }

    @JsonProperty("partyId")
    public void setPartyId(String partyId) {
       
		 this.partyId = partyId;
    }

    public SettlementGroupList withPartyId(String partyId) {
        this.partyId = partyId;
        return this;
    }

    @JsonProperty("settlementGroup")
    public List<SRV132> getSettlementGroup() {
        return settlementGroup;
    }

    @JsonProperty("settlementGroup")
    public void setSettlementGroup(List<SRV132> settlementGroup) {
        this.settlementGroup = settlementGroup;
    }

    public SettlementGroupList withSettlementGroup(List<SRV132> settlementGroup) {
        this.settlementGroup = settlementGroup;
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
