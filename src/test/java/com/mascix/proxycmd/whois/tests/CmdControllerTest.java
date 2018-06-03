package com.mascix.proxycmd.whois.tests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mascix.proxycmd.whois.CmdController;

public class CmdControllerTest {
	@Autowired
	CmdController cmdController;

	@Test
	public void test() throws Exception {
		assertThat(cmdController).isNotNull();
		String ip = "192.168.2.1";
		assertThat(cmdController.whois(ip)).isNotNull();
	}

}
