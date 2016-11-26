package fr.sorbonne.miage.m1.dao;

import fr.sorbonne.miage.m1.beans.Author;
import fr.sorbonne.miage.m1.beans.Book;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author eddebbima
 */
public class JdbcBookDao implements DAO<Book> {

    private EntityManager em;
    
    public JdbcBookDao(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("librarie");
        em = emf.createEntityManager();
    }
    
    @Override
    public List<Book> findAll() {
        System.out.println("I'm here");
        List<Book> books = new ArrayList<>();   
        books = em.createQuery("SELECT b FROM Book b", Book.class).getResultList();    
        if(books == null){
            out.println("error");
        }else{
            out.println("NO error");
        }
        return books;
    }

    @Override
    public Book findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      
    @Override
    public void create(Book b) {
        em.getTransaction().begin();
        em.persist(b);
        em.flush();
        em.merge(b);
        em.flush();
        em.getTransaction().commit();
    }

    @Override
    public void delete(Book t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Book t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
