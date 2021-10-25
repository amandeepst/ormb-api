package com.worldpay.servicing.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import com.worldpay.servicing.core.CoreConfiguration;
import com.worldpay.servicing.security.SecurityConfig;
@Configuration
@PropertySource({"file:${SDS_ENCRYPTED_DIR}/ormb-application.properties"})
@Import({CoreConfiguration.class, SecurityConfig.class})
public class ApplicationConfiguration {

}
