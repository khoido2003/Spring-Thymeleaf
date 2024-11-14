package dev.car;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class CarApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarApplication.class, args);
	}

	@Bean
	public CommandLineRunner testDatabaseConnection(JdbcTemplate jdbcTemplate) {
		return args -> {
			try {
				jdbcTemplate.execute("SELECT 1"); // Test the connection with a simple query
				System.out.println("Connected to MySQL database successfully.");
			} catch (Exception e) {
				System.err.println("Failed to connect to MySQL database.");
				e.printStackTrace();
			}
		};
	}

}
