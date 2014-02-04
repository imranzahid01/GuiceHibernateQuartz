package com.imranzahid.test.jobs;

import com.imranzahid.test.dao.EmployeeDao;
import com.imranzahid.test.entity.Employee;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import javax.inject.Inject;

/**
 * @author imranzahid Date: 2/3/14 Time: 3:22 PM
 */
public class ReportJob implements Job  {
  private static final Logger log = Logger.getLogger(ReportJob.class);
  @Inject private EmployeeDao employeeDao;

  @Override public void execute(JobExecutionContext context) throws JobExecutionException {
    Employee scott = employeeDao.getByName("scott");
    log.info(scott);
  }
}
