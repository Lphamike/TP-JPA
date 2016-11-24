/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.sorbonne.miage.m1.beans;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 *
 * @author madevaed
 */
@Entity(name="Author")
@Table(name = "author")
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "firstname")
    private String firstname;
    
    @NotNull
    @Size(min =1, max = 255)
    @Column(name="lastbame")
    private String lastname;
    
    @ManyToMany(mappedBy = "authors")
    private Collection<Book> books;
    
    public Author(){
        
    }
    
    public Author(String firstname, String lastname){
        this.firstname = firstname;
        this.lastname = lastname;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getFirstname(){
        return this.firstname;
    }
    
    public void setFirstname(String firstname){
        this.firstname = firstname;
    }
    
    public String getLastname(){
        return this.lastname;
    }
    
    public void setLastname(String lastname){
        this.lastname = lastname;
    }
    
    public Collection<Book> getBooks(){
        return this.books;
    }
    
    public void setBooks(Collection<Book> books){
        this.books = books;
    }

}
