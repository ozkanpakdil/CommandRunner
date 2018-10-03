package com.mascix.proxycmd.whois.service;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

import java.util.concurrent.TimeUnit;

@Service
public class CmdServiceImpl implements CmdService {
    private static final Logger logger = LoggerFactory.getLogger(CmdServiceImpl.class);

    @Override
    public String execToString(String ip) throws Exception {
        String c1 = "/bin/sh";
        if (System.getProperty("os.name").toLowerCase().contains("windows"))//check is OS windows
            return "pass";
        String[] cmd = {c1, "-c", "torify whois " + ip};

        ProcessBuilder pb = new ProcessBuilder(cmd);
        Process p = pb.start();
        p.waitFor(60, TimeUnit.SECONDS);

        return IOUtils.toString(p.getInputStream(), "UTF-8");
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
