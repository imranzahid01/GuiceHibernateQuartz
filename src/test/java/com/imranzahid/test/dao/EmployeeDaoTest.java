package com.imranzahid.test.dao;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.imranzahid.test.entity.Employee;
import com.imranzahid.test.initializer.ApplicationInitalizer;
import com.imranzahid.test.module.PersistenceModule;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author imranzahid Date: 2/3/14 Time: 11:37 PM
 */
public class EmployeeDaoTest {
  private static Injector injector;
  private static ApplicationInitalizer applicationInitalizer;

  @BeforeClass public static void beforeClass() {
    injector = Guice.createInjector(new PersistenceModule(), new JpaPersistModule("scott-db"));
    applicationInitalizer = injector.getInstance(ApplicationInitalizer.class);
    applicationInitalizer.init();
  }

  @AfterClass public static void afterClass() {
    applicationInitalizer.destroy();
  }

  @Test public void fetchEmployee() {
    EmployeeDao dao = injector.getInstance(EmployeeDao.class);
    Employee scott = dao.getByName("scott");
    Assert.assertNotNull("There should be an employee by the name of scott", scott);
  }
}
