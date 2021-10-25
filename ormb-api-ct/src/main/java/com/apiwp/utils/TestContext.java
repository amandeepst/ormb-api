package com.apiwp.utils;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Lazy
@Configuration
@ComponentScan(basePackages = { "com.apiwp" })
public class TestContext {
	@Autowired
	private Environment environment;

	
	private DataSource ormbCisadmDS;
	private DataSource ormbInMemDS;

	@Profile("!ormb-api-ct-in-mem")
	@Bean(name = "ormbCisadmDS")
	public DataSource cisadmDS() throws SQLException {
		if (ormbCisadmDS == null) {
			ormbCisadmDS = new HikariDataSource(cisadmCreateConfig("CISADM Pool", environment.getCisadmJdbcDriver(),
					environment.getCisadmJdbcUrl(), environment.getCisadmJdbcUsername(),
					EncryptionUtils.decrypt(environment.getCisadmJdbcPassword())));
		}
		return ormbCisadmDS;
	}

	@Profile("!ormb-api-ct-in-mem")
	@Bean(name = "ormbCisadm")
	public JdbcOperations cisadmOperations(@Qualifier("ormbCisadmDS") DataSource datasource) {
		return new JdbcOperations(new JdbcTemplate(datasource));
	}

	private HikariConfig cisadmCreateConfig(String poolName, String driver, String url, String username,
			String password) {
		HikariConfig config = new HikariConfig();
		config.setMaximumPoolSize(5);
		config.setConnectionTimeout(60000L);
		config.setMinimumIdle(2);
		config.setDriverClassName(driver);
		config.setJdbcUrl(url);
		config.setUsername(username);
		config.setPassword(password);
		config.setPoolName(poolName);

		return config;
	}
	@Profile("!ormb-api-ct")
	@Bean(name = "ormbInMemDS")
	public DataSource ormbInMemDS() throws SQLException {
		if (ormbInMemDS == null) {
			ormbInMemDS = new HikariDataSource(
					inMemCreateConfig("H2 Pool", environment.getOrmbJdbcDriver(), environment.getOrmbJdbcUrl(),
							environment.getOrmbJdbcUsername(), environment.getOrmbJdbcPassword()));
		}
		return ormbInMemDS;
	}
	@Profile("!ormb-api-ct")
	@Bean(name = "ormbInMem")
	public JdbcOperations ormbInMemOperations(@Qualifier("ormbInMemDS") DataSource datasource) {
		return new JdbcOperations(new JdbcTemplate(datasource));
	}

	private HikariConfig inMemCreateConfig(String poolName, String driver, String url, String username,
		String password) {

		HikariConfig config = new HikariConfig();
		config.setMaximumPoolSize(5);
		config.setConnectionTimeout(60000L);
		config.setMinimumIdle(2);
		config.setDriverClassName(driver);
		config.setJdbcUrl(url);
		config.setUsername(username);
		config.setPassword(password);
		config.setPoolName(poolName);
		return config;
	}

}
