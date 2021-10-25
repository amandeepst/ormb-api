package com.worldpay.servicing.core.service;
import java.util.List;
import com.worldpay.servicing.model.entity.SRV132;
public interface SRV132Service 
{
   List<SRV132> loadByPerIdNbr(String perIdNbr);
	String checkPerIdNbr(String perIdNbr);
	
}
