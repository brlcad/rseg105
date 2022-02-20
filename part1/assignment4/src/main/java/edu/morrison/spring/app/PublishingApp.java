package edu.morrison.spring.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

import edu.morrison.spring.beans.Book;
import edu.morrison.spring.beans.Category;


public class PublishingApp {

  private static Logger logger = LoggerFactory.getLogger(PublishingApp.class);

  public static void main(String... args) {
    Integer step = 4;

    logger.info("Book Publishing Hibernate Demo");
    logger.info("v0.0.1 by C.S. Morrison");
    logger.info("");
    logger.info("Usage: " + args[0] + "");
    logger.info("");
    logger.info("This is a demonstration of persisting entities via Spring Hibernate.");
    logger.info("");

    logger.info("============== Start of Publishing Demo =====================");


    logger.info("============== End of Publishing Demo =======================");

  }

}
