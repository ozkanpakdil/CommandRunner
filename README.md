# CommandRunner with spring-boot
to run the project in local
mvn spring-boot:run

test url http://localhost:8080/whois?ip=192.168.2.1

For caching hazelcast used.

run in the server

nohup mvn spring-boot:run > log.log 2>&1&

run in port 80
sudo mvn spring-boot:run -Dserver.port=80
