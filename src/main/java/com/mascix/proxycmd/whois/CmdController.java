package com.mascix.proxycmd.whois;

import java.io.ByteArrayOutputStream;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;
import org.apache.commons.validator.routines.InetAddressValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CmdController {
	private static final Logger logger = LoggerFactory.getLogger(CmdController.class);

	@Autowired
	private CacheManager cacheManager;

	@ResponseBody
	@RequestMapping(value = "/whois")
	public String whois(@RequestParam(name = "ip", required = true) String ip, Model model) throws Exception {
		String line = "torify whois " + ip;

		if (!InetAddressValidator.getInstance().isValid(ip)) {
			return "";
		}
		logger.info(line);
		return execToString(line);
	}

	@Cacheable
	public String execToString(String command) throws Exception {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		CommandLine commandline = CommandLine.parse(command);
		DefaultExecutor exec = new DefaultExecutor();
		PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);
		exec.setStreamHandler(streamHandler);
		exec.execute(commandline);
		return (outputStream.toString());
	}
}
