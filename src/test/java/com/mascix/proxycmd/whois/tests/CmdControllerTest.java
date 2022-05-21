package com.mascix.proxycmd.whois.tests;

import com.mascix.proxycmd.whois.CmdController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CmdControllerTest {
	@Autowired
	private CmdController cmdController;

	@Test
	public void whois() throws Exception {
		assertThat(cmdController).isNotNull();
		String ip = "192.168.2.1";
		assertThat(cmdController.whois(ip)).isNotNull();
	}
}
