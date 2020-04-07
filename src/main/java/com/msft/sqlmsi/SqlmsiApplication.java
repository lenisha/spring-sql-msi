package com.msft.sqlmsi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SqlmsiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SqlmsiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		SQLServerDataSource ds = new SQLServerDataSource();
		ds.setServerName(server + ".database.windows.net");
		ds.setDatabaseName(dbName);
		ds.setMSIClientId(msiClientId);
		ds.setAuthentication("ActiveDirectoryMSI");
		log.info("MSI : " + msiClientId);
		
		try (Connection connection = ds.getConnection()) {
		}
	}

}
