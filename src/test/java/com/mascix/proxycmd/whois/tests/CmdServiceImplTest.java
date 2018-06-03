package com.mascix.proxycmd.whois.tests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mascix.proxycmd.whois.service.CmdService;

public class CmdServiceImplTest {

	@Autowired
	CmdService cmdService;

	@Test
	public void test() throws Exception {
		assertThat(cmdService.execToString("192.168.1.1")).isNotNull();
	}

}
