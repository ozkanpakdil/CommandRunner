package com.mascix.proxycmd.whois.tests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.mascix.proxycmd.whois.CmdController;
import com.mascix.proxycmd.whois.service.CmdService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhoisApplicationTests {
	private static final Logger logger = LoggerFactory.getLogger(WhoisApplicationTests.class);
	@Autowired
	CmdController cmdController;

	@Autowired
	CmdService cmdService;

	@Autowired
	CacheManager chm;

	@Test
	public void contextLoads() throws Exception {
		assertThat(cmdController).isNotNull();

		for (String cacheName : chm.getCacheNames()) {
			logger.info(cacheName);
			// investigate later HazelcastInstance ins = (HazelcastInstance) chm.getCache(cacheName).getNativeCache();
		}

		cmdService.printCacheStats();

	}

}
