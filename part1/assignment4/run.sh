#!/bin/sh

mvn clean install
echo "=== Running PublishingApp ==========="
java -jar ./target/part1-assignment4.jar edu.morrison.spring.app.PublishingApp $*
