package com.imranzahid.test.jobs;

import com.imranzahid.test.dao.EmployeeDao;
import com.imranzahid.test.entity.Employee;
import org.apache.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import javax.inject.Inject;

/**
 * @author imranzahid Date: 2/3/14 Time: 3:12 PM
 */
@DisallowConcurrentExecution
public class EmployeeJob implements Job {
  private static final Logger log = Logger.getLogger(EmployeeJob.class);

  @Inject private EmployeeDao employeeDao;

  @Override public void execute(JobExecutionContext context) throws JobExecutionException {
    Employee scott = employeeDao.getByName("scott");
    log.info(scott);
    scott.setSalary(scott.getSalary() + (0.1*scott.getSalary()));
    employeeDao.update(scott);
    log.info(scott);
  }
}
