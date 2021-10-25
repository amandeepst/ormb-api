package com.worldpay.servicing.core;



import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;


@Configuration
@PropertySource({"classpath:servicing-application-test.properties"})
@Import(CoreConfiguration.class)
@EnableAutoConfiguration
@EnableCaching
public class CoreTestConfiguration 
{ 

@Autowired
private DataSource dataSource;

@Bean
@DependsOn("dataSource")
public DatabasePopulator databasePopulator(){
	DatabasePopulator databasePopulator = createDatabasePopulator();
    DatabasePopulatorUtils.execute(createDatabasePopulator(), dataSource);
    return databasePopulator;
}

 private DatabasePopulator createDatabasePopulator() 
 {
    ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
    databasePopulator.setContinueOnError(false);
    databasePopulator.addScript(new ClassPathResource("db/db-test-data.sql"));
    return databasePopulator;
}
 @Test
 public void testModelMapperBeanCreation() {
   ModelMapper modelMapper = new CoreConfiguration().modelMapper();
   assertNotNull("ModelMapper is null", modelMapper);
 }
}
