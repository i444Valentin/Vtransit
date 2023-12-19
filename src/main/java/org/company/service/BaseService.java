package org.company.service;

public interface BaseService<E> {
    public boolean save(E entity);
    public E findById(Integer id);
    public boolean deleteById(Integer id);
}
