<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title> viewBook </title>
</head>

<body>
	 <h1>Books List</h1>
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
	</body>
</html>