package com.imranzahid.test;

import com.imranzahid.test.dao.EmployeeDao;
import com.imranzahid.test.entity.Employee;
import org.apache.log4j.Logger;

import javax.inject.Inject;

/**
 * @author imranzahid Date: 2/3/14 Time: 10:49 AM
 */
public class Test {
  private static final Logger log = Logger.getLogger(Test.class);
  @Inject private EmployeeDao employeeDao;

  public Test() {}

  public void test() {
    Employee scott = employeeDao.getByName("scott");
    log.info(scott);
    scott.setSalary(scott.getSalary() + (0.1*scott.getSalary()));
    employeeDao.update(scott);
    log.info(scott);
  }
}
