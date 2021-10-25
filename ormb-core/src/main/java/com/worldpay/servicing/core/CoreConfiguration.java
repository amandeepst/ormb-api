package com.worldpay.servicing.core;

import com.worldpay.servicing.core.logging.LoggingMarker;
import com.worldpay.tpg.logging.TpgLogger;
import com.worldpay.tpg.logging.TpgLoggerFactory;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({"com.worldpay.servicing.core.dao", "com.worldpay.servicing.core.service"})
@EnableJpaRepositories("com.worldpay.servicing.core.dao")
@EntityScan("com.worldpay.servicing.model.entity")
@EnableTransactionManagement
public class CoreConfiguration {

  private static final TpgLogger logger = TpgLoggerFactory.getTpgLogger(CoreConfiguration.class);

  @Autowired
  private Environment env;


  @Bean(name = "dataSource", destroyMethod = "")
  public DataSource dataSource() {
    logger.info(LoggingMarker.CORE_CONFIG_INITIALIZING_DATASOURCE_INFO, "Initializing application datasource");
    DataSource ds = null;
    try {
      logger.info(LoggingMarker.CORE_CONFIG_LOADING_DATASOURCE_INFO, "Trying to load container-managed datasource:");
      ds = searchInternalDatasource();
      logger.info(LoggingMarker.CORE_CONFIG_PROVIDED_DATASOURCE_INFO, "Container provided datasource obtained.");
    } catch (NamingException ne) {
      logger.warn(LoggingMarker.CORE_CONFIG_NOT_FIND_DATASOURCE_WARN, "Could not find datasource in web container. "
          + "Creating datasource from application properties", ne.getMessage());
      ds = new HikariDataSource(createConfig());
      
    }
    return ds;
  }

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }

  private HikariConfig createConfig() {
    HikariConfig config = new HikariConfig();
    config.setMaximumPoolSize(env.getProperty("datasource.maxPoolSize", Integer.class));
    config.setConnectionTimeout(env.getProperty("datasource.connectionTimeout", Long.class));
    config.setMinimumIdle(env.getProperty("datasource.minPoolSize", Integer.class));
    config.setDriverClassName(env.getProperty("datasource.driverClass"));
    config.setJdbcUrl(env.getProperty("datasource.url"));
    config.setUsername(env.getProperty("datasource.username"));
    config.setPassword(env.getProperty("datasource.password"));
    config.setPoolName("ORMB Connection Pool");
    return config;
  }


  private DataSource searchInternalDatasource() throws NamingException {
    logger.info(LoggingMarker.CORE_CONFIG_JNDI_LOOKUP_INFO, "Using Jndi factory bean to lookup servicing datasource");
    JndiObjectFactoryBean factoryBean = new JndiObjectFactoryBean();
    factoryBean.setJndiName(env.getProperty("datasource.jndiName"));
    factoryBean.setExpectedType(DataSource.class);
    factoryBean.afterPropertiesSet();

    return (DataSource) factoryBean.getObject();
  }
}
