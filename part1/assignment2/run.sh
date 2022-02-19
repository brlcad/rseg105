#!/bin/sh

mvn clean install
echo "=== Running BookBeforeAdvice ==========="
java -cp ./target/part1.assignment2-1.0.0.jar edu.morrison.spring.app.BookBeforeAdvice
echo "=== Running BookAfterReturningAdvice ==="
java -cp ./target/part1.assignment2-1.0.0.jar edu.morrison.spring.app.BookAfterReturningAdvice
echo "=== Running BookThrowsAdvice ==========="
java -cp ./target/part1.assignment2-1.0.0.jar edu.morrison.spring.app.BookThrowsAdvice
