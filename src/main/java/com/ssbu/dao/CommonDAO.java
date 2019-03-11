package com.ssbu.dao;

import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class CommonDAO<T> implements DAO<T> {

    @PersistenceContext
    private EntityManager entityManager;
    private Class<T> type;

    public CommonDAO() {
        this(null);
    }

    public CommonDAO(final Class<T> clazz) {
        this.setType(clazz);
    }

    @Override
    public T save(final T entity) {
        this.getEntityManager().persist(entity);
        this.getEntityManager().flush();

        return entity;
    }

    @Override
    public T find(final Integer id) {
        return this.getEntityManager().find(this.getType(), id);
    }

    public List<T> find(final String sql, final Consumer<TypedQuery<T>> queryConsumer) {
        System.out.println(this.getType().getSimpleName());
        final TypedQuery<T> query = this.getEntityManager().createQuery(sql, this.getType());

        if (queryConsumer != null) {
            queryConsumer.accept(query);
        }

        return query.getResultList();
    }

    @Override
    public void remove(final T entity) {
        this.getEntityManager().remove(entity);
    }

    public Long count(final String sql) {
        return this.count(sql, null);
    }

    public Long count(final String sql, final Consumer<TypedQuery<Long>> queryConsumer) {
        final TypedQuery<Long> query = this.getEntityManager().createQuery(sql, Long.class);

        if (queryConsumer != null) {
            queryConsumer.accept(query);
        }

        return query.getSingleResult();
    }

    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    public void setEntityManager(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Class<T> getType() {
        return this.type;
    }

    public void setType(final Class<T> type) {
        this.type = type;
    }
}
