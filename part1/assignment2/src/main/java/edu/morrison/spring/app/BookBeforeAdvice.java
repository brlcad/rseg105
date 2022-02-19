package edu.morrison.spring.app;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.morrison.spring.app.AppConfig;
import edu.morrison.spring.beans.Book;


public class BookBeforeAdvice implements MethodBeforeAdvice {
	private static final Logger logger = LoggerFactory.getLogger(BookBeforeAdvice.class);

  public static void main(String[] args) {
    GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("BookBeans.xml");
		context.refresh();

		Book book = (Book)context.getBean("978-0075536321");

    ProxyFactory factory = new ProxyFactory();
    factory.addAdvice(new BookBeforeAdvice());
    factory.setTarget(book);

    Book proxy = (Book) factory.getProxy();

    proxy.reading();

    context.close();
  }

  @Override
  public void before(Method method, Object[] args, Object target)
    throws Throwable {
    logger.info("Before '" + method.getName() + "' buy the book.");
  }
}
