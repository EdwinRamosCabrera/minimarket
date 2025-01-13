package com.market.minimarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MinimarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinimarketApplication.class, args);
	}

}
