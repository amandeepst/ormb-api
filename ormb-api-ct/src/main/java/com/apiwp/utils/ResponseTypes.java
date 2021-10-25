package com.apiwp.utils;

import com.worldpay.servicing.model.entity.SRV131JsonPojo;
import com.worldpay.servicing.model.entity.SRV132JsonPojo;
import com.worldpay.servicing.model.entity.SRV130JsonPojo;
import com.worldpay.servicing.model.entity.SRV133JsonPojo;

public enum ResponseTypes {

	OPENBILLS(SRV131JsonPojo.class),
	MERCHANTSETTLEMENTGROUP(SRV132JsonPojo.class),
  	MERCHANTBALANCE(SRV130JsonPojo.class),
 	MERCHANTPRICING(SRV133JsonPojo.class);
	
  private Class returnTypeClass;

  ResponseTypes(Class returnTypeClass) {
    this.returnTypeClass = returnTypeClass;
  }

  public static Class getEnumValueByName(String name) {
    for (ResponseTypes responseTypes : ResponseTypes.values()) {
      if (responseTypes.name().equalsIgnoreCase(name)) {
        return responseTypes.getResponseTypeClass();
      }
    }
    return null;
  }

  public Class getResponseTypeClass() {
    return this.returnTypeClass;
  }
}