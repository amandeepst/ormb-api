package com.worldpay.servicing.core.service;

import java.util.List;

import org.javasimon.aop.Monitored;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.worldpay.servicing.core.dao.SRV132Repository;
import com.worldpay.servicing.core.logging.LoggingMarker;
import com.worldpay.servicing.model.entity.SRV132;
import com.worldpay.tpg.logging.TpgLogger;
import com.worldpay.tpg.logging.TpgLoggerFactory;

@Service
@Monitored
public class SRV132ServiceImpl implements SRV132Service {
	
	private static final TpgLogger logger = TpgLoggerFactory.getTpgLogger(SRV132ServiceImpl.class);
	
	@Autowired
	private SRV132Repository srv132Repository;

	@Override
	public List<SRV132> loadByPerIdNbr(String perIdNbr) {
		logger.info(LoggingMarker.SRV_132_LOADING_DATA_BY_PARTYID_INFO, "Finding merchant settlement group for partyId {}", perIdNbr);
		return srv132Repository.findByPerIdNbr(perIdNbr);
	}

	@Override
	public String checkPerIdNbr(String perIdNbr) {
		logger.info(LoggingMarker.SRV_132_CHECK_DATA_BY_PARTYID_INFO, "Check merchant settlement group for partyId {}", perIdNbr);
		return srv132Repository.checkPerIdNbr(perIdNbr);
	}
}
