package fr.sorbonne.miage.m1.dao;

import fr.sorbonne.miage.m1.beans.Author;
import fr.sorbonne.miage.m1.beans.Book;
import java.util.List;

/**
 *
 * @author eddebbima
 */
public interface DAO<T> {
    
    public List<T> findAll();
    
    public T findById(int id);
    
    public void create(Book b, Author a);
}
