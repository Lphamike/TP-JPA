/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.sorbonne.miage.m1.dao;

import fr.sorbonne.miage.m1.entity.Author;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Eddie
 */
public class JdbcAuthorDao implements DAO<Author>{

    private EntityManager em;
    
    public JdbcAuthorDao(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("livres");
        em = emf.createEntityManager();
    }
    
    @Override
    public List<Author> findAll() {
        CriteriaQuery<Author> criteria = em.getCriteriaBuilder().createQuery(Author.class);
        criteria.select(criteria.from(Author.class));
        List<Author> ListOfAuthors = em.createQuery(criteria).getResultList();
        return ListOfAuthors;
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
    public void delete(Author a) {
        em.getTransaction().begin();
        em.remove(a);
        em.getTransaction().commit();
    }

    @Override
    public void update(Author a, Author n) {
         em.getTransaction().begin();
         a.setFirstname(n.getFirstname());
         a.setLastname(n.getLastname());
         em.getTransaction().commit();
    }
    
}
