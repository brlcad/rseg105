#!/bin/sh

mvn clean install
mvn exec:java -Dexec.mainClass="edu.morrison.spring.app.App"
