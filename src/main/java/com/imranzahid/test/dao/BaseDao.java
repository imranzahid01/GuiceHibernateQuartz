package com.imranzahid.test.dao;

import com.google.inject.persist.Transactional;

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

  public BaseDao(Class<E> entityClass) {
    this.entityClass = entityClass;
  }

  public EntityManager getEntityManager() {
    return entityManager;
  }

  protected EntityType<E> getMetaModel() {
    return getEntityManager().getMetamodel().entity(entityClass);
  }

  @Transactional public void create(E entity) {
    getEntityManager().persist(entity);
  }

  @Transactional public void update(E entity) {
    getEntityManager().merge(entity);
  }

  @Transactional public void remove(int entityId) {
    E entity = find(entityId);

    if (entity != null) {
      remove(entity);
    }
  }

  @Transactional public void remove(E entity) {
    getEntityManager().remove(getEntityManager().merge(entity));
  }

  public E find(Object id) {
    return getEntityManager().find(entityClass, id);
  }

  public List<E> findAll() {
    CriteriaQuery<E> cq = getEntityManager().getCriteriaBuilder().createQuery(entityClass);
    cq.select(cq.from(entityClass));
    return getEntityManager().createQuery(cq).getResultList();
  }

  public List<E> findRange(int[] range) {
    CriteriaQuery<E> cq = getEntityManager().getCriteriaBuilder().createQuery(entityClass);
    cq.select(cq.from(entityClass));

    Query q = getEntityManager().createQuery(cq);
    q.setMaxResults(range[1] - range[0]);
    q.setFirstResult(range[0]);

    //noinspection unchecked
    return q.getResultList();
  }
}
