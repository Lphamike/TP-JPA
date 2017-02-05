package fr.sorbonne.miage.m1.dao;

import fr.sorbonne.miage.m1.entity.Author;
import fr.sorbonne.miage.m1.entity.Book;
import java.util.List;

/**
 *
 * @author eddebbima
 */
public interface DAO<T> {
    
    public List<T> findAll();
    
    public T findById(int id);
    
    public void create(T t);
    
    public void delete(T t);
    
    public void update(T t, T n);
    
}
