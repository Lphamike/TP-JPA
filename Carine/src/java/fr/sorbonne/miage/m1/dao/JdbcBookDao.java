package fr.sorbonne.miage.m1.dao;

import fr.sorbonne.miage.m1.entity.Author;
import fr.sorbonne.miage.m1.entity.Book;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author eddebbima
 */
public class JdbcBookDao implements DAO<Book> {

    private EntityManager em;
    
    public JdbcBookDao(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("livres");
        em = emf.createEntityManager();
    }
    
    @Override
    public List<Book> findAll() {
        /*System.out.println("I'm here");
        List<Book> books = new ArrayList<>();   
        books = em.createQuery("SELECT b FROM Book b", Book.class).getResultList();    
        if(books == null){
            out.println("error");
        }else{
            out.println("NO error");
        }
        return books;*/
        CriteriaQuery<Book> criteria = em.getCriteriaBuilder().createQuery(Book.class);
        criteria.select(criteria.from(Book.class));
        List<Book> ListOfBooks = em.createQuery(criteria).getResultList();
        return ListOfBooks;
    }

    @Override
    public Book findById(int id) {
        return em.find(Book.class, id);
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
        em.getTransaction().begin();
        em.remove(t);
        em.getTransaction().commit();
    }

    @Override
    public void update(Book t, Book n) {
        em.getTransaction().begin();
        t.setAuthors(n.getAuthors());
        t.setPrice(n.getPrice());
        t.setTitle(n.getTitle());
        em.getTransaction().commit();
    }

}
