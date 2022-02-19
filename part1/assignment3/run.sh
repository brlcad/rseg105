#!/bin/sh

mvn clean install
echo "=== Running FindBookCategoryJdbcApp ==========="
java -jar ./target/part1-assignment3.jar edu.morrison.spring.app.FindBookCategoryJdbcApp $*
