package com.mascix.proxycmd.whois;

import java.io.ByteArrayOutputStream;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;
import org.apache.commons.validator.routines.InetAddressValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CmdController {

	@ResponseBody
	@RequestMapping(value = "/whois")
	public String whois(@RequestParam(name = "ip", required = true) String ip, Model model) throws Exception {

		if (!InetAddressValidator.getInstance().isValid(ip)) {
			return "";
		}

		String line = "torify whois " + ip;
		return execToString(line);
	}

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
