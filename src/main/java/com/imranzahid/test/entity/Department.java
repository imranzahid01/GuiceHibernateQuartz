package com.imranzahid.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author imranzahid Date: 2/3/14 Time: 10:03 AM
 */
@Entity
@Table(name = "dept")
public class Department {
  @Id
  @Column(name = "deptno", nullable = false)
  private int id;

  @Column(name = "dname", nullable = true)
  private String name;

  @Column(name = "loc", nullable = true)
  private String location;

  public Department() {}

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

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) { return true; }
    if (o == null || !(o instanceof Department)) { return false; }

    Department that = (Department) o;

    return id == that.id;
  }

  @Override
  public int hashCode() {
    return id;
  }

  @Override public String toString() {
    return "Department{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", location='" + location + '\'' +
        '}';
  }
}
