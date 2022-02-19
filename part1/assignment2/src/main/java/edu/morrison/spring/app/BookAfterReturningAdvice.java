package edu.morrison.spring.app;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.morrison.spring.app.AppConfig;
import edu.morrison.spring.beans.Book;


public class BookAfterReturningAdvice implements AfterReturningAdvice {
	private static final Logger logger = LoggerFactory.getLogger(BookAfterReturningAdvice.class);

  public static void main(String[] args) {
    GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("BookBeans.xml");
		context.refresh();

		Book book = (Book)context.getBean("978-0060194994");

    ProxyFactory factory = new ProxyFactory();
    factory.addAdvice(new BookAfterReturningAdvice());
    factory.setTarget(book);

    Book proxy = (Book) factory.getProxy();

    proxy.reading();

    context.close();
  }

  @Override
  public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
    logger.info("After '" + method.getName() + "' write the book review.");
  }
}
