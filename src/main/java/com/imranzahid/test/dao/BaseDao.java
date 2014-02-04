package com.imranzahid.test.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.metamodel.EntityType;
import java.util.List;

/**
 * @author imranzahid Date: 2/3/14 Time: 10:19 AM
 */
public abstract class BaseDao<E> {
  protected Class<E> entityClass;

  @Inject private EntityManager entityManager;
  private boolean inTransaction = false;

  public BaseDao(Class<E> entityClass) {
    this.entityClass = entityClass;
  }

  public EntityManager getEntityManager() {
    return entityManager;
  }

  public void beginTransaction() {
    if (inTransaction) {
      return;
    }
    inTransaction = true;
    getEntityManager().getTransaction().begin();
  }

  public void endTransaction() {
    if (!inTransaction) {
      return;
    }
    inTransaction = false;
    getEntityManager().getTransaction().commit();
  }

  protected EntityType<E> getMetaModel() {
    return getEntityManager().getMetamodel().entity(entityClass);
  }

  public void create(E entity) {
    beginTransaction();
    getEntityManager().persist(entity);
    endTransaction();
  }

  public void update(E entity) {
    beginTransaction();
    getEntityManager().merge(entity);
    endTransaction();
  }

  public void remove(int entityId) {
    beginTransaction();
    E entity = find(entityId);

    if (entity != null) {
      remove(entity);
    }
    endTransaction();
  }

  public void remove(E entity) {
    beginTransaction();
    getEntityManager().remove(getEntityManager().merge(entity));
    endTransaction();
  }

  public E find(Object id) {
    return getEntityManager().find(entityClass, id);
  }

  public List<E> findAll() {
    CriteriaQuery<E> cq = getEntityManager().getCriteriaBuilder().createQuery(entityClass);
    cq.select(cq.from(entityClass));
    return getEntityManager().createQuery(cq).getResultList();
  }

  @SuppressWarnings("unchecked") public List<E> findRange(int[] range) {
    CriteriaQuery<E> cq = getEntityManager().getCriteriaBuilder().createQuery(entityClass);
    cq.select(cq.from(entityClass));

    Query q = getEntityManager().createQuery(cq);
    q.setMaxResults(range[1] - range[0]);
    q.setFirstResult(range[0]);

    return q.getResultList();
  }
}
