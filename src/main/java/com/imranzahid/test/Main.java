package com.imranzahid.test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.imranzahid.test.jobs.EmployeeTask;
import com.imranzahid.test.module.ApacheQuartzModule;
import com.imranzahid.test.module.PersistenceModule;
import com.imranzahid.test.initializer.ApplicationInitalizer;
import org.apache.log4j.Logger;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author imranzahid Date: 2/3/14 Time: 10:44 AM
 */
public class Main {
  private static final Logger log = Logger.getLogger(Main.class);

  public static void main(String[] args) {
    log.info("Creating injector");
    final Injector injector = Guice.createInjector(new PersistenceModule(), new JpaPersistModule("scott-db"));

    log.info("Initializing Application");
    final ApplicationInitalizer applicationInitalizer = injector.getInstance(ApplicationInitalizer.class);
    applicationInitalizer.init();

    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override public void run() {
        applicationInitalizer.destroy();
      }
    });

    final int SECOND = 1_000;
    final int MINUTE = 60 * SECOND;
    final int HOUR = 60 * MINUTE;

    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
      @Override public void run() {
        injector.getInstance(EmployeeTask.class).run();
      }
    };
    timer.schedule(task, 0L, 5 * SECOND);
    /*log.info("Testing app");
    Test test = injector.getInstance(Test.class);
    test.test();*/
  }
}
