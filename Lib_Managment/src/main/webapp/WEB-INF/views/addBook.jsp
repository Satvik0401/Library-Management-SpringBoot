<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title> Add Book</title>
</head>	

  <body>
	
	<h1> Add Book Details <h1>
	<form action="/books/addBook" method="POST">
		<label for="title"> Title: </label>
		<input type="text" id="title" name="title" required><br><br>
		
		<label for="author" > Author: </label>
		<input type="text" id="author" name=author required><br><br>
		
		<label for="genre"> Genre: </label>
		<input type="text" id="genre" name="genre"><br><br>
		
		<button type="submit">Add Book</button>
	</form>
	
</body>
</html>