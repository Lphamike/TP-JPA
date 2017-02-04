package fr.sorbonne.miage.m1.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity(name="Book")
@Table(name = "book")
public class Book implements Serializable{
    
    @Id
    @NotNull
    @Column(name = "isbn")
    private Integer isbn;
    
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "title")
    private String title;
    
    @NotNull
    @Column(name = "price")
    private Float price;
       
    @JoinTable(name="COMPO_AUTHOR_BOOK",
            joinColumns = @JoinColumn(name="BOOK_isbn", referencedColumnName="isbn"),
            inverseJoinColumns = @JoinColumn(name="AUTHOR_id", referencedColumnName="id"))
    @ManyToMany
    private Collection<Author> authors;
    
    public Book(){
        
    }
    
    public Book(Integer isbn, String title, Float price) {
        this.isbn = isbn;
        this.title = title;
        this.price = price;
        this.authors = new ArrayList<>();
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
        
    public Collection<Author> getAuthors(){
        return this.authors;
    }
    
    public void setAuthors(Collection<Author> authors){
        this.authors = authors;
    }
 
}
