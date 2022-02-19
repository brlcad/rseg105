package edu.morrison.spring.app;

import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DeadlockLoserDataAccessException;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;


public class MySQLErrorCodesTranslator extends SQLErrorCodeSQLExceptionTranslator {

  @Override
  protected DataAccessException customTranslate(String task, String sql, SQLException oops) {
    if (oops.getErrorCode() == -12345) {
      return new DeadlockLoserDataAccessException(task, oops);
    }
    return null;
  }

}
