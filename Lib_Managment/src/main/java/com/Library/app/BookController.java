package com.Library.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import jakarta.validation.Valid;
import java.util.*;
//import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {
	@Autowired
	BookRepo bookRepository;
	
	@GetMapping("/Menu")
	public String showMenu(Model model) {
	    model.addAttribute("book", new Book()); // Create an empty Book object to bind form fields
	    return "Menu"; // Return the name of the JSP page (addBook.jsp)
	}

	
	//View Insert
	@GetMapping("/addBook")
	public String showAddBookForm(Model model) {
	    model.addAttribute("book", new Book()); // Create an empty Book object to bind form fields
	    return "addBook"; // Return the name of the JSP page (addBook.jsp)
	}
	
	//Implement Insert
	@PostMapping("/addBook")
	public String create(@Valid @ModelAttribute Book book, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "/addBook";
		}
		bookRepository.save(book);
		return "redirect:/books/Menu";
	}
	
	//Read All
	@GetMapping("/viewBooks")
    public String getAllBooks(Model model) 
	{
		List<Book> books=bookRepository.findAll();
		model.addAttribute("books", books);
        return "viewBooks";
    }
	
	//Search using genre, author or title
	  @GetMapping("/searchBook")
	    public String searchBookForm() {
	        return "searchBook"; // View to display the search form
	    }

	    @PostMapping("/searchBook")
	    public String searchBook(@RequestParam String query, Model model) {
	        List<Book> books = bookRepository.findByTitleContainingOrAuthorContainingOrGenreContaining(query, query, query);
	        model.addAttribute("books", books);
	        return "searchBook"; // Display search results
	    }
	
	//Update
	@PutMapping("/update/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable Integer id, @RequestBody Book updateBook)
	{
		Optional<Book> existingBook=bookRepository.findById(id);
		
		if(existingBook.isPresent())
		{
			Book book=existingBook.get();
			book.setTitle(updateBook.getTitle());
			book.setAuthor(updateBook.getAuthor());
			book.setGenre(updateBook.getGenre());
			Book updatedBook=bookRepository.save(book);
			return ResponseEntity.ok(updatedBook);
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/delete/{id}")
		public ResponseEntity<String> deleteBook(@PathVariable Integer id)
		{
			Optional<Book> existingBook=bookRepository.findById(id);
			
			if(existingBook.isPresent())
			{
				bookRepository.deleteById(id);
				return ResponseEntity.ok("Deleted");
			}
			else
			{ return ResponseEntity.notFound().build();
		    }
	}
	
	
}
