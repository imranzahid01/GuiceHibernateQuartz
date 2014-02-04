package com.imranzahid.test.dao;

import com.imranzahid.test.entity.Department;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * @author imranzahid Date: 2/3/14 Time: 10:25 AM
 */
public class DepartmentDao extends BaseDao<Department> {
  public DepartmentDao() {
    super(Department.class);
  }

  public Department getByName(String name) {
    CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
    CriteriaQuery<Department> cq = cb.createQuery(Department.class);
    Root<Department> person = cq.from(Department.class);
    cq.where(cb.equal(person.get("name"), name));
    return getEntityManager().createQuery(cq).getSingleResult();
  }
}
