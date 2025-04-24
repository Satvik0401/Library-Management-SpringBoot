<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Book</title>
</head>
<body>
    <h1>Search Books</h1>
    <form action="/books/searchBook" method="POST">
        <input type="text" name="query" placeholder="Enter book title, author, or genre" required>
        <button type="submit">Search</button>
    </form>

    <c:if test="${not empty books}">
        <h2>Search Results:</h2>
        <table>
            <tr>
                <th>Title</th>
                <th>Author</th>
                <th>Genre</th>
            </tr>
            <c:forEach var="book" items="${books}">
                <tr>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                    <td>${book.genre}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</body>
</html>
