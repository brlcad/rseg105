#!/bin/sh

mvn clean install
echo "=== Running PublishingApp ==========="
java -jar ./target/part2-assignment2.jar edu.morrison.spring.app.PublishingApp $*
