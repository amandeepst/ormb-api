package com.worldpay.servicing.core.logging;

import com.worldpay.tpg.common.annotation.Annotation;
import org.slf4j.Marker;

public class LoggingMarker {

  public static final Annotation CORE_CONFIG_JNDI_LOOKUP_INFO = new Annotation("5038400010",
      "CORE_CONFIG_JNDI_LOOKUP_INFO");
  public static final Annotation CORE_CONFIG_NOT_FIND_DATASOURCE_WARN = new Annotation("5038400022",
      "CORE_CONFIG_NOT_FIND_DATASOURCE_WARN");
  public static final Annotation CORE_CONFIG_PROVIDED_DATASOURCE_INFO = new Annotation("5038400030",
      "CORE_CONFIG_PROVIDED_DATASOURCE_INFO");
  public static final Annotation CORE_CONFIG_LOADING_DATASOURCE_INFO = new Annotation("5038400040",
      "CORE_CONFIG_LOADING_DATASOURCE_INFO");
  public static final Annotation CORE_CONFIG_INITIALIZING_DATASOURCE_INFO = new Annotation(
      "5038400050", "CORE_CONFIG_INITIALIZING_DATASOURCE_INFO");
  public static final Annotation SRV_130_LOADING_DATA_BY_PARTYID_INFO = new Annotation("5038400060",
      "SRV_130_LOADING_DATA_BY_PARTYID_INFO");
  public static final Annotation SRV_133_LOADING_ALL_DATA_INFO = new Annotation("5038400070",
      "SRV_133_LOADING_ALL_DATA_INFO");
  public static final Annotation SRV_133_LOADING_DATA_BY_PARTYID_INFO = new Annotation("5038400080",
      "SRV_133_LOADING_DATA_BY_PARTYID_INFO");
  public static final Annotation SRV_132_LOADING_DATA_BY_PARTYID_INFO = new Annotation("5038400090",
      "SRV_132_LOADING_DATA_BY_PARTYID_INFO");
  public static final Annotation SRV_131_LOADING_ALL_DATA_INFO = new Annotation("5038400100",
      "SRV_131_LOADING_ALL_DATA_INFO");

  public static final Annotation SRV_131_LOADING_DATA_BY_PARTYID_INFO = new Annotation("5038400110",
      "SRV_131_LOADING_DATA_BY_PARTYID_INFO");
  public static final Annotation SRV_130_CHECK_DATA_BY_PARTYID_INFO = new Annotation("5038400120",
      "SRV_130_CHECK_DATA_BY_PARTYID_INFO");
  public static final Annotation SRV_132_CHECK_DATA_BY_PARTYID_INFO = new Annotation("5038400130",
      "SRV_132_CHECK_DATA_BY_PARTYID_INFO");
}
