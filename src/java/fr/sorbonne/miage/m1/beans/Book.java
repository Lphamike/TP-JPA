package fr.sorbonne.miage.m1.beans;

public class Book {
    
    private Integer isbn;
    private String title;
    private Float price;
    
    public Book(Integer isin, String title, Float price) {
        this.isbn = isin;
        this.title = title;
        this.price = price;
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
}
