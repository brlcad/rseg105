package edu.morrison.spring.app;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.morrison.spring.app.AppConfig;
import edu.morrison.spring.beans.Book;


public class BookThrowsAdvice implements ThrowsAdvice {
	private static final Logger logger = LoggerFactory.getLogger(BookThrowsAdvice.class);

  public static void main(String[] args) {
    GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("BookBeans.xml");
		context.refresh();

		Book book = (Book)context.getBean("978-0137150021");

    ProxyFactory factory = new ProxyFactory();
    factory.addAdvice(new BookThrowsAdvice());
    factory.setTarget(book);

    Book proxy = (Book) factory.getProxy();

    try {
      proxy.throwException();
    } catch (Exception ignored) {
    }

    context.close();
  }

  public void afterThrowing(Exception ex) throws Throwable {
    logger.info("***");
    logger.info("Exception Captured");
    logger.info("Caught: " + ex.getClass().getName());
    System.out.print("***\n");
  }

  public void afterThrowing(Method method, Object[] args, Object target, RuntimeException ex) throws Throwable {
    logger.info("***");
    logger.info("RuntimeException Captured");
    logger.info("Caught: " + ex.getClass().getName());
    logger.info("Method: " + method.getName());
    System.out.print("***\n");
  }
}
