package edu.morrison.spring.app;

import org.springframework.context.support.GenericXmlApplicationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

import edu.morrison.spring.beans.Book;
import edu.morrison.spring.beans.Category;


public class PublishingApp {

  private static GenericXmlApplicationContext context = new GenericXmlApplicationContext();
  private static Logger logger = LoggerFactory.getLogger(FindBookCategoryJdbcApp.class);

  public static void main(String... args) {
    Integer step = 4;
    context.load("classpath:spring/app-context-xml.xml");
    context.refresh();

    logger.info("Book Publishing Hibernate Demo");
    logger.info("v0.0.1 by C.S. Morrison");
    logger.info("");
    logger.info("Usage: " + args[0] + "");
    logger.info("");
    logger.info("This is a demonstration of persisting entities via Spring Hibernate.");
    logger.info("");

    logger.info("============== Start of Publishing Demo =====================");


    logger.info("============== End of Publishing Demo =======================");

    context.close();
  }

}
