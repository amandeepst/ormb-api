
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
    "balanceList"
})
public class Balance {

    @JsonProperty("partyId")
    private String partyId;
    @JsonProperty("balanceList")
    private List<SRV130>  balanceList = new ArrayList<SRV130>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("partyId")
    public String getPartyId() {
        return partyId;
    }

    @JsonProperty("partyId")
    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public Balance withPartyId(String partyId) {
        this.partyId = partyId;
        return this;
    }

    @JsonProperty("balanceList")
    public List<SRV130> getBalanceList() {
        return balanceList;
    }

    @JsonProperty("balanceList")
    public void setBalanceList(List<SRV130> balanceList) {
        this.balanceList = balanceList;
    }

    public Balance withBalanceList(List<SRV130> balanceList) {
        this.balanceList = balanceList;
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
