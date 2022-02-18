#!/bin/sh

mvn clean install
java -jar ./target/part1.assignment2-1.0.0.jar edu.morrison.spring.app.BookBeforeAdvice
java -jar ./target/part1.assignment2-1.0.0.jar edu.morrison.spring.app.BookAfterReturningAdvice
java -jar ./target/part1.assignment2-1.0.0.jar edu.morrison.spring.app.BookThrowsAdvice
