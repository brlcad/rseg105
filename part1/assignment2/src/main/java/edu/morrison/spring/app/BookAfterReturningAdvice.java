package edu.morrison.spring.app;


import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.morrison.spring.app.AppConfig;
import edu.morrison.spring.beans.Book;


public class BookAfterReturningAdvice {
	private static final Logger logger = LoggerFactory.getLogger(BookAfterReturningAdvice.class);

  public static void main(String[] args) {
    GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("BookBeans.xml");
		context.refresh();

		Book book = (Book)context.getBean("978-0060194994");
		logger.info("Book: " + book);

    context.close();
  }
}
