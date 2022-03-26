
package edu.morrison.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.context.support.GenericXmlApplicationContext;

import edu.morrison.spring.beans.Book;


public class BookWebApp {

  private static Logger logger = LoggerFactory.getLogger(BookWebApp.class);
  //private static GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();

  public static void main(String... args) {

    //    ctx.load("classpath:spring/app-context-annotation.xml");
    //    ctx.refresh();

    logger.info("Book WebApp Demo");
    logger.info("v0.0.1 by C.S. Morrison");
    logger.info("");
    logger.info("Usage: " + args[0]);
    logger.info("");
    logger.info("This is a demonstration of a Spring MVC application.");
    //    logger.info("Specify number to run each specific demo in succession (allowing database inspection).");
    logger.info("");

    if (args.length > 1) {
      demo = Integer.parseInt(args[1]);
    }
    if (demo < 0) {
      logger.error("Expecting no argument or demo number after " + args[0]);
      return;
    }

    logger.info("============== Start of Book WebApp Demo =====================");


    logger.info("============== End of Book WebApp Demo =======================");

  }

}
