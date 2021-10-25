
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
    "subAccountCode",
    "subAccountDescription",
    "currency",
    "legalCounterpartyShortCode",
    "legalCounterpartyDescription",
    "legalCounterparty"
})
public class SettlementGroup {

    @JsonProperty("subAccountCode")
    private String subAccountCode;
    @JsonProperty("subAccountDescription")
    private String subAccountDescription;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("legalCounterpartyShortCode")
    private String legalCounterpartyShortCode;
    @JsonProperty("legalCounterpartyDescription")
    private String legalCounterpartyDescription;
    @JsonProperty("legalCounterparty")
    private String legalCounterparty;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("subAccountCode")
    public String getSubAccountCode() {
        return subAccountCode;
    }

    @JsonProperty("subAccountCode")
    public void setSubAccountCode(String subAccountCode) {
        this.subAccountCode = subAccountCode;
    }

    public SettlementGroup withSubAccountCode(String subAccountCode) {
        this.subAccountCode = subAccountCode;
        return this;
    }

    @JsonProperty("subAccountDescription")
    public String getSubAccountDescription() {
        return subAccountDescription;
    }

    @JsonProperty("subAccountDescription")
    public void setSubAccountDescription(String subAccountDescription) {
        this.subAccountDescription = subAccountDescription;
    }

    public SettlementGroup withSubAccountDescription(String subAccountDescription) {
        this.subAccountDescription = subAccountDescription;
        return this;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public SettlementGroup withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    @JsonProperty("legalCounterpartyShortCode")
    public String getLegalCounterpartyShortCode() {
        return legalCounterpartyShortCode;
    }

    @JsonProperty("legalCounterpartyShortCode")
    public void setLegalCounterpartyShortCode(String legalCounterpartyShortCode) {
        this.legalCounterpartyShortCode = legalCounterpartyShortCode;
    }

    public SettlementGroup withLegalCounterpartyShortCode(String legalCounterpartyShortCode) {
        this.legalCounterpartyShortCode = legalCounterpartyShortCode;
        return this;
    }

    @JsonProperty("legalCounterpartyDescription")
    public String getLegalCounterpartyDescription() {
        return legalCounterpartyDescription;
    }

    @JsonProperty("legalCounterpartyDescription")
    public void setLegalCounterpartyDescription(String legalCounterpartyDescription) {
        this.legalCounterpartyDescription = legalCounterpartyDescription;
    }

    public SettlementGroup withLegalCounterpartyDescription(String legalCounterpartyDescription) {
        this.legalCounterpartyDescription = legalCounterpartyDescription;
        return this;
    }

    @JsonProperty("legalCounterparty")
    public String getLegalCounterparty() {
        return legalCounterparty;
    }

    @JsonProperty("legalCounterparty")
    public void setLegalCounterparty(String legalCounterparty) {
        this.legalCounterparty = legalCounterparty;
    }

    public SettlementGroup withLegalCounterparty(String legalCounterparty) {
        this.legalCounterparty = legalCounterparty;
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

    public SettlementGroup withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    

}
