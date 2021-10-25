package com.worldpay.servicing.web;

import org.javasimon.console.SimonConsoleServlet;
import org.javasimon.spring.MonitoredMeasuringPointcut;
import org.javasimon.spring.MonitoringInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("monitored")
public class JavaSimonConfig {

  @Bean(name = "monitoringAdvisor")
  public DefaultPointcutAdvisor monitoringAdvisor() {
    DefaultPointcutAdvisor monitoringAdvisor = new DefaultPointcutAdvisor();
    monitoringAdvisor.setAdvice(new MonitoringInterceptor());
    monitoringAdvisor.setPointcut(new MonitoredMeasuringPointcut());
    return monitoringAdvisor;
  }

  @Bean
  public ServletRegistrationBean<SimonConsoleServlet> dispatcherRegistration() {
    ServletRegistrationBean<SimonConsoleServlet> registration = new ServletRegistrationBean(
        new SimonConsoleServlet());
    registration.addInitParameter("url-prefix", "/javasimon");
    registration.addUrlMappings("/javasimon/*");
    return registration;
  }

}
