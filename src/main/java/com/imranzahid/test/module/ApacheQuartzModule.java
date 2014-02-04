package com.imranzahid.test.module;

import com.imranzahid.test.jobs.EmployeeJob;
import com.imranzahid.test.jobs.ReportJob;

import java.util.Properties;

/**
 * @author imranzahid Date: 2/3/14 Time: 3:08 PM
 */
public class ApacheQuartzModule extends org.apache.onami.scheduler.QuartzModule {
  @Override protected void schedule() {
    Properties properties = new Properties();
    properties.put("org.quartz.scheduler.instanceName", "MyScheduler");
    properties.put("org.quartz.threadPool.threadCount", "2");
    properties.put("org.quartz.jobStore.class", "org.quartz.simpl.RAMJobStore");
    configureScheduler().withProperties(properties).withManualStart();
    scheduleJob(EmployeeJob.class).withJobName("employeeJob").withCronExpression("0/5 * * * * ?");
    scheduleJob(ReportJob.class).withJobName("reportJob").withCronExpression("0/3 * * * * ?");
  }
}
