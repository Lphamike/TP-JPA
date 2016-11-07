package fr.sorbonne.miage.m1.dao;

import java.util.List;

/**
 *
 * @author eddebbima
 */
public interface DAO<T> {
    
    public List<T> findAll();
    
    public T findById(int id);
}
