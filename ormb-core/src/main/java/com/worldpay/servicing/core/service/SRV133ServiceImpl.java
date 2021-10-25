package com.worldpay.servicing.core.service;

import java.util.List;

import org.javasimon.aop.Monitored;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.worldpay.servicing.core.dao.SRV133Repository;
import com.worldpay.servicing.core.logging.LoggingMarker;
import com.worldpay.servicing.model.entity.SRV133;
import com.worldpay.servicing.model.entity.SRV133Request;
import com.worldpay.tpg.logging.TpgLogger;
import com.worldpay.tpg.logging.TpgLoggerFactory;

@Service
@Monitored
public class SRV133ServiceImpl implements SRV133Service {

	private static final TpgLogger logger = TpgLoggerFactory.getTpgLogger(SRV133ServiceImpl.class);
	
	
	@Autowired
	SRV133Repository ser133Repository;

	@Override
	public List<SRV133> findByAll(SRV133Request srv133Request){
		logger.info(LoggingMarker.SRV_133_LOADING_ALL_DATA_INFO,"Finding all pricing data for request {}", srv133Request.toString());
		return ser133Repository.findByAll(srv133Request);
	}
	@Override
	public String checkPerIdNbr(String perIdNbr) {
		logger.info(LoggingMarker.SRV_133_LOADING_DATA_BY_PARTYID_INFO, "Finding pricing data for partyId {}", perIdNbr);
		return ser133Repository.checkPerIdNbr(perIdNbr);

	}
}
