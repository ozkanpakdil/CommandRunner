# CommandRunner with spring-boot 
![Build Status](https://github.com/ozkanpakdil/CommandRunner/actions/workflows/maven.yml/badge.svg) [![Quality gate](https://sonarcloud.io/api/project_badges/quality_gate?project=ozkanpakdil_CommandRunner)](https://sonarcloud.io/summary/new_code?id=ozkanpakdil_CommandRunner) [![Known Vulnerabilities](https://snyk.io/test/github/ozkanpakdil/CommandRunner/badge.svg)](https://snyk.io/test/github/ozkanpakdil/CommandRunner) ![release](https://github.com/ozkanpakdil/CommandRunner/workflows/release/badge.svg)

to run the project in local
mvn spring-boot:run

test url http://localhost:8080/whois?ip=192.168.2.1

Caching: hazelcast

run in the server

nohup mvn spring-boot:run > log.log 2>&1&

run in port 80
sudo mvn spring-boot:run -Dserver.port=80

