#!/bin/sh

mysql -uroot < src/main/resources/sql/ddl.sql
mysql -uspring -pspring morebooks < src/main/resources/sql/schema.sql
mysql -uspring -pspring morebooks < src/main/resources/sql/test-data.sql

mvn clean install
echo "=== Running PublishingApp ==========="
java -jar ./target/part2-assignment1.jar edu.morrison.spring.app.PublishingApp $*
