/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.sorbonne.miage.m1.beans;

import fr.sorbonne.miage.m1.entity.Book;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author maximer
 */
@Stateless
public class BookFacade extends AbstractFacade<Book> implements BookFacadeLocal {
    //@PersistenceContext(unitName = "livres")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("livres");
        em = emf.createEntityManager();
        return em;
    }

    public BookFacade() {
        super(Book.class);
    }
    
}
