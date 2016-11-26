/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.sorbonne.miage.m1.dao;

import fr.sorbonne.miage.m1.beans.Author;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Eddie
 */
public class JdbcAuthorDao implements DAO<Author>{

    private EntityManager em;
    
    public JdbcAuthorDao(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("librarie");
        em = emf.createEntityManager();
    }
    
    @Override
    public List<Author> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Author findById(int id) {
        return em.find(Author.class, id);
    }

    @Override
    public void create(Author a) {
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Author t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Author t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
