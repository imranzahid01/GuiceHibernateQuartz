package com.imranzahid.test.dao;

import com.imranzahid.test.entity.Employee;
import org.apache.log4j.Logger;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 * @author imranzahid Date: 2/3/14 Time: 10:25 AM
 */
public class EmployeeDao extends BaseDao<Employee> {
  private static final Logger log = Logger.getLogger(EmployeeDao.class);

  public EmployeeDao() {
    super(Employee.class);
  }

  public Employee getByName(String name) {
    CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
    CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
    cq.where(cb.equal(cq.from(Employee.class).get("name"), name));
    return getEntityManager().createQuery(cq).getSingleResult();
  }
}
