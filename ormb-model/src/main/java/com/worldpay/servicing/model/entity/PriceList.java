
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
    "rank",
    "priceId",
    "partyId",
    "chargeType",
    "chargeTypeDescr",
    "perItemRate",
    "percentRate",
    "startDate",
    "endDate",
    "priceConfig",
    "currencycd"
})

public class PriceList {

    @JsonProperty("rank")
    private String rank;
    @JsonProperty("priceId")
    private String priceId;
    @JsonProperty("partyId")
    private String partyId;
    @JsonProperty("chargeType")
    private String chargeType;
    @JsonProperty("chargeTypeDescr")
    private String chargeTypeDescr;
    @JsonProperty("perItemRate")
    private List<Object> perItemRate = new ArrayList<Object>();
    @JsonProperty("percentRate")
    private String percentRate;
    @JsonProperty("startDate")
    private String startDate;
    @JsonProperty("endDate")
    private String endDate;
    @JsonProperty("priceConfig")
    private String priceConfig;
    @JsonProperty("currencycd")
    private String currencycd;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("rank")
    public String getRank() {
        return rank;
    }

    @JsonProperty("rank")
    public void setRank(String rank) {
        this.rank = rank;
    }

    public PriceList withRank(String rank) {
        this.rank = rank;
        return this;
    }

    @JsonProperty("priceId")
    public String getPriceId() {
        return priceId;
    }

    @JsonProperty("priceId")
    public void setPriceId(String priceId) {
        this.priceId = priceId;
    }

    public PriceList withPriceId(String priceId) {
        this.priceId = priceId;
        return this;
    }

    @JsonProperty("partyId")
    public String getPartyId() {
        return partyId;
    }

    @JsonProperty("partyId")
    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public PriceList withPartyId(String partyId) {
        this.partyId = partyId;
        return this;
    }

    @JsonProperty("chargeType")
    public String getChargeType() {
        return chargeType;
    }

    @JsonProperty("chargeType")
    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public PriceList withChargeType(String chargeType) {
        this.chargeType = chargeType;
        return this;
    }

    @JsonProperty("chargeTypeDescr")
    public String getChargeTypeDescr() {
        return chargeTypeDescr;
    }

    @JsonProperty("chargeTypeDescr")
    public void setChargeTypeDescr(String chargeTypeDescr) {
        this.chargeTypeDescr = chargeTypeDescr;
    }

    public PriceList withChargeTypeDescr(String chargeTypeDescr) {
        this.chargeTypeDescr = chargeTypeDescr;
        return this;
    }

    @JsonProperty("perItemRate")
    public List<Object> getPerItemRate() {
        return perItemRate;
    }

    @JsonProperty("perItemRate")
    public void setPerItemRate(List<Object> perItemRate) {
        this.perItemRate = perItemRate;
    }

    public PriceList withPerItemRate(List<Object> perItemRate) {
        this.perItemRate = perItemRate;
        return this;
    }

    @JsonProperty("percentRate")
    public String getPercentRate() {
        return percentRate;
    }

    @JsonProperty("percentRate")
    public void setPercentRate(String percentRate) {
        this.percentRate = percentRate;
    }

    public PriceList withPercentRate(String percentRate) {
        this.percentRate = percentRate;
        return this;
    }

    @JsonProperty("startDate")
    public String getStartDate() {
        return startDate;
    }

    @JsonProperty("startDate")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public PriceList withStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    @JsonProperty("endDate")
    public String getEndDate() {
        return endDate;
    }

    @JsonProperty("endDate")
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public PriceList withEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    @JsonProperty("currencycd")
    public String getCurrencycd() {
        return currencycd;
    }

    @JsonProperty("currencycd")
    public void setCurrencycd(String currencycd) {
        this.currencycd = currencycd;
    }

    public PriceList withCurrencycd(String currencycd) {
        this.currencycd = currencycd;
        return this;
    }

    
    @JsonProperty("priceConfig")
    public String getPriceConfig() {
        return priceConfig;
    }

    @JsonProperty("priceConfig")
    public void setPriceConfig(String priceConfig) {
        this.priceConfig = priceConfig;
    }

    public PriceList withPriceConfig(String priceConfig) {
        this.priceConfig = priceConfig;
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
