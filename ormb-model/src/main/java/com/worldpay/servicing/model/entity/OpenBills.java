
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
    "billList"
})

public class OpenBills {

    @JsonProperty("billList")
    private List<SRV131> billList = new ArrayList<SRV131>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("billList")
    public List<SRV131> getBillList() {
        return billList;
    }

    @JsonProperty("billList")
    public void setBillList(List<SRV131> billList) {
        this.billList = billList;
    }

    public OpenBills withBillList(List<SRV131> billList) {
        this.billList = billList;
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
