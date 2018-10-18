package com.mascix.proxycmd.whois.tests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import com.mascix.proxycmd.whois.service.CmdService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CmdServiceImplTest {

    @Autowired
    private CmdService cmdService;

    @Test
    public void execToString() throws Exception {
        assertThat(cmdService.execToString("192.168.1.1")).isNotNull();
    }

    @Test
    public void printCacheStats() {
        cmdService.printCacheStats();
    }
}
