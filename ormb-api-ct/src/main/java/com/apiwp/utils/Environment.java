package com.apiwp.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:/environments/${environment}")
public class Environment {

  @Value("${URL}")
  private String url;

  @Value("${PORT}")
  private String port;

  @Value("${cisadm.jdbc.url}")
  private String cisadmJdbcUrl;

  @Value("${cisadm.jdbc.username}")
  private String cisadmJdbcUsername;

  @Value("${cisadm.jdbc.password}")
  private String cisadmJdbcPassword;

  @Value("${cisadm.jdbc.driver}")
  private String cisadmJdbcDriver;

  @Value("${ormb.jdbc.url}")
  private String ormbJdbcUrl;
  
  @Value("${ormb.jdbc.username}")
  private String ormbJdbcUsername;
  
  @Value("${ormb.jdbc.password}")
  private String ormbJdbcPassword;
  
  @Value("${ormb.jdbc.driver}")
  private String ormbJdbcDriver;

	

public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getPort() {
    return port;
  }

  public void setPort(String port) {
    this.port = port;
  }

  public String getCisadmJdbcUrl() {
    return cisadmJdbcUrl;
  }

  public void setCisadmJdbcUrl(String cisadmJdbcUrl) {
    this.cisadmJdbcUrl = cisadmJdbcUrl;
  }

  public String getCisadmJdbcUsername() {
    return cisadmJdbcUsername;
  }

  public void setCisadmJdbcUsername(String cisadmJdbcUsername) {
    this.cisadmJdbcUsername = cisadmJdbcUsername;
  }

  public String getCisadmJdbcPassword() {
    return cisadmJdbcPassword;
  }

  public void setCisadmJdbcPassword(String cisadmJdbcPassword) {
    this.cisadmJdbcPassword = cisadmJdbcPassword;
  }

  public String getCisadmJdbcDriver() {
    return cisadmJdbcDriver;
  }
 

  public String getOrmbJdbcUrl() {
	return ormbJdbcUrl;
}

public void setOrmbJdbcUrl(String ormbJdbcUrl) {
	this.ormbJdbcUrl = ormbJdbcUrl;
}

public String getOrmbJdbcUsername() {
	return ormbJdbcUsername;
}

public void setOrmbJdbcUsername(String ormbJdbcUsername) {
	this.ormbJdbcUsername = ormbJdbcUsername;
}

public String getOrmbJdbcPassword() {
	return ormbJdbcPassword;
}

public void setOrmbJdbcPassword(String ormbJdbcPassword) {
	this.ormbJdbcPassword = ormbJdbcPassword;
}

public String getOrmbJdbcDriver() {
	return ormbJdbcDriver;
}

public void setOrmbJdbcDriver(String ormbJdbcDriver) {
	this.ormbJdbcDriver = ormbJdbcDriver;
}

public void setCisadmJdbcDriver(String cisadmJdbcDriver) {
    this.cisadmJdbcDriver = cisadmJdbcDriver;
  }
}
