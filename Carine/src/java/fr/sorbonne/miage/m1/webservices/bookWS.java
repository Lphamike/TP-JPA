/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.sorbonne.miage.m1.webservices;

import fr.sorbonne.miage.m1.entity.Book;
import fr.sorbonne.miage.m1.dao.DAO;
import fr.sorbonne.miage.m1.dao.JdbcBookDao;
import java.util.List;
import static javafx.application.Platform.exit;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author maximer
 */
@WebService(serviceName = "bookWS")
public class bookWS {

    private DAO<Book> bookDao;
    
    /**
     * This is a sample web service operation
     * @return 
     */
    @WebMethod(operationName = "getBooks")
    public List<Book> getBooks() {
        bookDao = new JdbcBookDao();
        List<Book> books = bookDao.findAll();
        return books;
    }
    
    @WebMethod(operationName = "hello")
    public String hello() {
        return "Hello";
    }
}
