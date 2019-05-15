package com.mascix.proxycmd.whois;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;
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
        Config cfg = new Config();
        MapConfig defaultMapConfig = new MapConfig();
        defaultMapConfig.setName("default");
        defaultMapConfig.setTimeToLiveSeconds(60 * 10);
        defaultMapConfig.setEvictionPolicy(EvictionPolicy.LFU);
        defaultMapConfig.setMaxIdleSeconds(60 * 10);
        MaxSizeConfig defaultMaxSizeConfig = new MaxSizeConfig();
        defaultMaxSizeConfig.setSize(1000);
        defaultMaxSizeConfig.setMaxSizePolicy(MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE);
        defaultMapConfig.setMaxSizeConfig(defaultMaxSizeConfig);
        cfg.addMapConfig(defaultMapConfig);
        return Hazelcast.newHazelcastInstance(cfg);
    }
}
