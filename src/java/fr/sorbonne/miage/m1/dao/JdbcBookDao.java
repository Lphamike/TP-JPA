package fr.sorbonne.miage.m1.dao;

import fr.sorbonne.miage.m1.beans.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eddebbima
 */
public class JdbcBookDao implements DAO<Book> {

    // JDBC driver name and database URL
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/NOM_DE_LA_BASE";

    //  Database credentials
    private static final String USER = "LOGIN_MYSQL";
    private static final String PASS = "MDP_MYSQL";

    private Connection connection;

    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        try {
            Statement stmt = getConnection().createStatement();
            String sql = "SELECT * FROM Book";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                Integer isbn = rs.getInt("isbn");
                String title = rs.getString("title");
                Float price = rs.getFloat("price");
                
                Book b = new Book(isbn, title, price);
                books.add(b);
            }
            
            return books;
        } catch (SQLException e) {
            e.printStackTrace();
            return books;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return books;
        }
    }

    @Override
    public Book findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
