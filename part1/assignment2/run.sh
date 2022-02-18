#!/bin/sh

mvn clean install
java -cp ./target/part1.assignment2-1.0.0.jar edu.morrison.spring.app.BookBeforeAdvice
java -cp ./target/part1.assignment2-1.0.0.jar edu.morrison.spring.app.BookAfterReturningAdvice
java -cp ./target/part1.assignment2-1.0.0.jar edu.morrison.spring.app.BookThrowsAdvice
