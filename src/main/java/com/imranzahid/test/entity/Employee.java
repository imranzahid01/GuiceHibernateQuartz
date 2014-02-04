package com.imranzahid.test.entity;

import javax.persistence.*;

/**
 * @author imranzahid Date: 2/3/14 Time: 10:03 AM
 */
@Entity
@Table(name = "emp")
public class Employee {
  @Id
  @Column(name = "empno", nullable = false)
  private int id;

  @Column(name = "ename", nullable = true)
  private String name;

  @Column(name = "job", nullable = true)
  private String job;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "mgr", nullable = true)
  private Employee manager;

  @Column(name = "sal", nullable = true, precision = 7, scale = 2, columnDefinition = "decimal")
  private Double salary;

  @Column(name = "comm", nullable = true, precision = 7, scale = 2, columnDefinition = "decimal")
  private Double commision;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "deptno", nullable = true, insertable = false, updatable = false)
  private Department department;

  public Employee() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getJob() {
    return job;
  }

  public void setJob(String job) {
    this.job = job;
  }

  public Employee getManager() {
    return manager;
  }

  public void setManager(Employee manager) {
    this.manager = manager;
  }

  public Double getSalary() {
    return salary;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }

  public Double getCommision() {
    return commision;
  }

  public void setCommision(Double commision) {
    this.commision = commision;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) { return true; }
    if (o == null || !(o instanceof Employee)) { return false; }

    Employee that = (Employee) o;

    return id == that.id;
  }

  @Override
  public int hashCode() {
    return id;
  }

  @Override public String toString() {
    return "Employee{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", job='" + job + '\'' +
        ", salary=" + salary +
        ", commision=" + commision +
        '}';
  }
}
