package com.mascix.proxycmd.whois.tests;

import com.mascix.proxycmd.whois.CmdController;
import com.mascix.proxycmd.whois.service.CmdService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class WhoisApplicationTests {
    private static final Logger logger = LoggerFactory.getLogger(WhoisApplicationTests.class);
    @Autowired
    private CmdController cmdController;

    @Autowired
    private CmdService cmdService;

    @Autowired
    private CacheManager chm;

    @Test
    public void main() {
        assertThat(cmdController).isNotNull();

        for (String cacheName : chm.getCacheNames()) {
            logger.info(cacheName);
            // investigate later HazelcastInstance ins = (HazelcastInstance) chm.getCache(cacheName).getNativeCache();
        }
    }

    @Test
    public void cacheManager() {
        assertThat(chm).isNotNull();
    }

    @Test
    public void hazelcastInstance() {
        assertThat(chm).isNotNull();
    }
}
