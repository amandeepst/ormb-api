package com.apiwp.utils;

import java.sql.SQLException;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ConnectionUtils {

	@Autowired
	@Qualifier("ormbInMemDS")
	private DataSource dataSource;

	@PostConstruct
    public void init() {
        try {
			Connection.setConnection(dataSource.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
