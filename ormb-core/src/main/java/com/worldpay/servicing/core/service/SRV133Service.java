package com.worldpay.servicing.core.service;

import java.util.List;

import com.worldpay.servicing.model.entity.SRV133;
import com.worldpay.servicing.model.entity.SRV133Request;

public interface SRV133Service {

	List<SRV133> findByAll(SRV133Request srv133Request);

	String checkPerIdNbr(String perIdNbr);

}
