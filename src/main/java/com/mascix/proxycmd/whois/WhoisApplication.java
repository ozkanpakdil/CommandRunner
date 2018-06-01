package com.mascix.proxycmd.whois;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.spring.cache.HazelcastCacheManager;

@EnableCaching
@EnableScheduling
@SpringBootApplication
public class WhoisApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhoisApplication.class, args);
	}

	@Bean
	CacheManager cacheManager() {
		return new HazelcastCacheManager(hazelcastInstance());
	}

	@Bean
	HazelcastInstance hazelcastInstance() {
		 return Hazelcast.newHazelcastInstance();
	}
}
