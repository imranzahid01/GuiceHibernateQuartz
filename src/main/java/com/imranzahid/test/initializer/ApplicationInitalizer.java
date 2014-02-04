package com.imranzahid.test.initializer;

import com.google.inject.Inject;
import com.google.inject.persist.PersistService;
import org.apache.log4j.Logger;
import org.quartz.*;


/**
 * @author imranzahid Date: 2/3/14 Time: 10:45 AM
 */
public class ApplicationInitalizer implements Initalizer {
  private static final Logger log = Logger.getLogger(ApplicationInitalizer.class);

  @Inject private PersistService persistenceService;
  @Inject(optional = true) private Scheduler scheduler;

  public ApplicationInitalizer() { }

  @Override public void init() {
    log.info("Initializing Persistence Service");
    persistenceService.start();
    if (scheduler != null) {
      try {
        log.info("Initializing Scheduler");
        scheduler.start();
      } catch (SchedulerException e) {
        e.printStackTrace();
      }
    }
  }

  @Override public void destroy() {
    log.info("Destroying Persistence Service");
    persistenceService.stop();
    if (scheduler != null) {
      try {
        log.info("Destroying Scheduler");
        scheduler.shutdown();
      } catch (SchedulerException e) {
        log.error("Unable to shutdown scheduler", e);
      }
    }
  }
}
