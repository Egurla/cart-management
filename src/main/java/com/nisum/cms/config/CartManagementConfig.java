package com.nisum.cms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.nisum.cms.repository")
public class CartManagementConfig {

	
	
}
