#!/bin/sh

mysql -uroot < src/main/resources/sql/ddl.sql
mysql -uspring -pspring mvcbooks < src/main/resources/sql/schema.sql
mysql -uspring -pspring mvcbooks < src/main/resources/sql/test-data.sql

mvn clean install
echo "=== Running BookWebApp ==========="

# java -jar ./target/part2-assignment3.jar edu.morrison.spring.BookWebApp $*
