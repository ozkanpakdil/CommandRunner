package com.mascix.proxycmd.whois;

import org.apache.commons.validator.routines.InetAddressValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mascix.proxycmd.whois.service.CmdService;

@Controller
public class CmdController {
	private static final Logger logger = LoggerFactory.getLogger(CmdController.class);

	@Autowired
	CmdService cmd;

	@ResponseBody
	@RequestMapping(value = "/whois")
	public String whois(@RequestParam(name = "ip", required = true) String ip) throws Exception {
		String line = "torify whois " + ip;

		if (!InetAddressValidator.getInstance().isValid(ip)) {
			return "";
		}
		logger.info(line);
		return cmd.execToString(line);
	}

}
