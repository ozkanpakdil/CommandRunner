package com.mascix.proxycmd.whois.service;

public interface CmdService {

	String execToString(String line) throws Exception;

	void printCacheStats();
}
