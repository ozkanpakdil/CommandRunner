package com.mascix.proxycmd.whois.tests;

import com.mascix.proxycmd.whois.service.CmdService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

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
