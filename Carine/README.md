# INF2 - TP JPA

#### Installation

Ce projet fonctionne sous :

- Netbeans 8.2
- GlassFish 4.1.1
- MySQL 5.6.15

La base de données doit être créée avant d'exécuter l'application. Vous pouvez utiliser le script SQL fourni. Le nom de la base de données dans le script est **Library**.

Vous devez renseigner vos identifiants pour MySQL *(configurés lors de l'installation)* :

```
// Fichier JdbcBookDao.java

public class JdbcBookDao implements DAO<Book> {

    // JDBC driver name and database URL
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/NOM_DE_LA_BASE";

    //  Database credentials
    private static final String USER = "LOGIN_MYSQL";
    private static final String PASS = "MDP_MYSQL";
```

#### Bon courage !
