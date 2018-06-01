package com.mascix.proxycmd.whois.service;

import java.io.ByteArrayOutputStream;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

@Service
@CacheConfig(cacheNames = "whois")
public class CmdServiceImpl implements CmdService {
	private static final Logger logger = LoggerFactory.getLogger(CmdServiceImpl.class);

	@Override
	@Cacheable
	public String execToString(String command) throws Exception {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		CommandLine commandline = CommandLine.parse(command);
		DefaultExecutor exec = new DefaultExecutor();
		PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);
		exec.setStreamHandler(streamHandler);
		exec.execute(commandline);
		System.out.println("cache " + command);
		return (outputStream.toString());
	}

	@Override
	@Scheduled(fixedRate = 5000 * 12)
	public void printCacheStats() {
		for (HazelcastInstance ins : Hazelcast.getAllHazelcastInstances()) {
			logger.info(ins.getName());
			IMap<Object, Object> map = ins.getMap("whois");
			logger.info(map.getLocalMapStats().toJson().toString());
		}
	}
}
