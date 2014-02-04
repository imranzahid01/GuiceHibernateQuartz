package com.imranzahid.test.jobs;

import com.imranzahid.test.dao.EmployeeDao;
import com.imranzahid.test.entity.Employee;
import org.apache.log4j.Logger;

import javax.inject.Inject;
import java.util.TimerTask;

/**
 * @author imranzahid Date: 2/3/14 Time: 6:49 PM
 */
public class EmployeeTask extends TimerTask {
  private static final Logger log = Logger.getLogger(EmployeeTask.class);

  @Inject private EmployeeDao employeeDao;

  @Override public void run() {
    Employee scott = employeeDao.getByName("scott");
    log.info(scott);
    scott.setSalary(scott.getSalary() + (0.1*scott.getSalary()));
    employeeDao.update(scott);
    log.info(scott);
  }
}
