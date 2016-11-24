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

    // JDBC driver name and database URL
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/library";

    //  Database credentials
    private static final String USER = "root";
    private static final String PASS = "";

    private Connection connection;
    
    private EntityManager em;
    
    public JdbcBookDao(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("INF2_JPAPU");
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
    public void create(Book b, Author a) {
        em.getTransaction().begin();
        em.persist(b);
        em.flush();
        b.getAuthors().add(a);
        b.getAuthors().add(new Author("Champion", "Champion"));
        em.merge(b);
        em.flush();
        em.getTransaction().commit();
    }

    /**
     * Method that creates a java.sql.Connection object to database
     *
     * @return java.sql.Connection
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    private Connection getConnection() throws ClassNotFoundException, SQLException {
        if (connection != null) {
            return connection;
        }
        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(DB_URL, USER, PASS);
        return connection;
    }

}
