package com.CTDECommerce.ECommerce;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ECommerceApplication {
	private static final Logger LOG = LoggerFactory.getLogger(ECommerceApplication.class);

	public static void main(String[] args) {
		LOG.info("Iniciando Api E-commerce.");
		SpringApplication.run(ECommerceApplication.class, args);
		LOG.info("Api E-commerce iniciado com sucesso.");
	}
}
