package edu.morrison.spring.app;


import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.morrison.spring.app.AppConfig;
import edu.morrison.spring.beans.Book;
import edu.morrison.spring.beans.Category;


public class App {
	private static final Logger logger = LoggerFactory.getLogger(App.class);

  public static void main(String[] args) {
    //		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("BookBeans.xml");
		context.refresh();

    Category set = (Category)context.getBean("Novels");
    Category list = (Category)context.getBean("Poetry");
    Category map = (Category)context.getBean("Java");

    logger.info(set.toString());
    logger.info(list.toString());
    logger.info(map.toString());

    // ByType Autowiring
		// Book book = (Book)context.getBean("book");
		// logger.info("Book (By Type Autowiring): " + book);

    context.close();
  }
}
