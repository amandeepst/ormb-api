package com.worldpay.servicing.core.service;

import java.util.List;

import org.javasimon.aop.Monitored;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worldpay.servicing.core.dao.SRV131Repository;
import com.worldpay.servicing.core.logging.LoggingMarker;
import com.worldpay.servicing.model.entity.SRV131;
import com.worldpay.servicing.model.entity.SRV131Request;
import com.worldpay.tpg.logging.TpgLogger;
import com.worldpay.tpg.logging.TpgLoggerFactory;

@Service
@Monitored
public class SRV131ServiceImpl implements SRV131Service {

	private static final TpgLogger logger = TpgLoggerFactory.getTpgLogger(SRV131ServiceImpl.class);

	@Autowired
	private SRV131Repository srv131Repository;

	@Override
	public List<SRV131> findByAll(SRV131Request srv131Request){
		logger.info(LoggingMarker.SRV_131_LOADING_ALL_DATA_INFO,"Finding all merchant open bills for request {}", srv131Request.toString());
		return srv131Repository.findByAll(srv131Request);
	}
	
	@Override
	public List<String> checkPerIdNbr(List<String> perIdNbr) {
		logger.info(LoggingMarker.SRV_131_LOADING_DATA_BY_PARTYID_INFO,"Finding merchant open bills for partyId {}", perIdNbr);
		return srv131Repository.checkPerIdNbr(perIdNbr);

	}

}
