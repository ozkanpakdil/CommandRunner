package com.mascix.proxycmd.whois;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class WhoisApplication {
	@Autowired
	private CacheManager cacheManager;

	public static void main(String[] args) {
		SpringApplication.run(WhoisApplication.class, args);
	}
}
