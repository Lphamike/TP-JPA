<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bibliothèque</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <style>
            body {
                width: 960px;
                margin: 30px;
            }
        </style>
    </head>
    <body>
        <h1>Liste des livres</h1>
        <br/>
        <c:if test="${books.size() > 0}">
            <table class="table table-bordered table-striped">
                <tr>
                    <th>ISBN</th>
                    <th>Nom du livre</th>
                    <th>Prix</th>
                    <th>Auteurs</th>
                    <th>Supprimer le livre</th>
                </tr>
                <c:forEach items="${books}" var="book">
                    <tr>
                        <td>${book.isbn}</td>
                        <td>${book.getTitle()}</td>
                        <td>${book.getPrice()}</td>
                        <td>
                            <table class="table">
                                <c:forEach items="${book.getAuthors()}" var="author">
                                        <tr><td>${author.lastname} ${author.firstname}</td></tr>
                                        <tr>X</tr>
                                </c:forEach>
                            </table>
                        </td>
                        <td><!--<button type="button" class="btn btn-danger">Supprimer</button>--></td>    
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <h3>Ajouter un livre : </h3>
        <form action="${pageContext.request.contextPath}/ajouterLivre" method="post">
            <h4>Livre : </h4>
            <table>
                <tr>
                    <td>Numéro ISBN : </td>
                    <td><input type="text" name="isbn"></td>
                </tr>
                <tr>
                    <td>Nom du livre : </td>
                    <td><input type="text" name="book_name"></td>
                </tr>
                <tr>
                    <td>Prix : </td>
                    <td><input type="number" step="0.01" name="book_price"><td>
                </tr>
            </table>
            <h4>Auteur : </h4>
            <table>
                <tr>    
                    <td>Nom de l'auteur : </td>
                    <td><input type="text" name="author_firstname"></td>
                </tr>
                <tr>
                    <td>Prénom de l'auteur : </td>
                    <td><input type="text" name="author_lastname"></td>
                </tr>
            </table>
            <button type="submit">Valider</button>
        </form>       
    </body>
</html>