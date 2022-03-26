#!/bin/sh

mvn clean install
echo "=== Running PublishingApp ==========="
java -jar ./target/part2-assignment1.jar edu.morrison.spring.app.PublishingApp $*
