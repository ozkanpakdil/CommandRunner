package com.mascix.proxycmd.whois.tests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import com.mascix.proxycmd.whois.CmdController;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
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
