package com.worldpay.servicing.core.service;

import java.util.List;

import com.worldpay.servicing.model.entity.SRV130;

public interface SRV130Service {
	List<SRV130> loadByPerIdNbr(String perIdNbr);

	String checkPerIdNbr(String perIdNbr);
}
