package com.worldpay.servicing.core.service;

import java.util.List;

import com.worldpay.servicing.model.entity.SRV131;
import com.worldpay.servicing.model.entity.SRV131Request;

public interface SRV131Service {

	List<SRV131> findByAll(SRV131Request srv131Request);
	
	List<String> checkPerIdNbr(List<String> perIdNbr);

}
