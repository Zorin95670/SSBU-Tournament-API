package com.ssbu.dao;

import java.util.List;

import com.ssbu.model.QueryOption;

public interface DAO<T> {

    Long count(final T entity);

    T save(final T entity);

    List<T> find(final T entity, final QueryOption queryOptions);

    T find(final Integer id);

    T find(final String name);

    void remove(final T entity);
}
