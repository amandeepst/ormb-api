package com.worldpay.servicing.core.service;

import java.util.List;

import org.javasimon.aop.Monitored;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.worldpay.servicing.core.dao.SRV130Repository;
import com.worldpay.servicing.core.logging.LoggingMarker;
import com.worldpay.servicing.model.entity.SRV130;
import com.worldpay.tpg.logging.TpgLogger;
import com.worldpay.tpg.logging.TpgLoggerFactory;

@Service
@Monitored
public class SRV130ServiceImpl implements SRV130Service {

	private static final TpgLogger logger = TpgLoggerFactory.getTpgLogger(SRV130ServiceImpl.class);

	@Autowired
	private SRV130Repository srv130Repository;

	@Override
	public List<SRV130> loadByPerIdNbr(String perIdNbr) {
		logger.info(LoggingMarker.SRV_130_LOADING_DATA_BY_PARTYID_INFO, "Finding merchant balance data for partyId {}", perIdNbr);
		return srv130Repository.findByPerIdNbr(perIdNbr);
		}

	@Override
	public String checkPerIdNbr(String perIdNbr) {
		logger.info(LoggingMarker.SRV_130_CHECK_DATA_BY_PARTYID_INFO, "Check merchant balance data for partyId {}", perIdNbr);
		return	srv130Repository.checkPerIdNbr(perIdNbr);

	}



}
