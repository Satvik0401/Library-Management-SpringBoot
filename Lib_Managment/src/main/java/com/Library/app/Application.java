package com.Library.app;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
	
@SpringBootApplication
public class Application implements CommandLineRunner {

	//@Autowired
   // private BookRepo bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception 
    {
//        Book book = new Book();
//        book.setTitle("Spring Boot in Action");
//        book.setAuthor("Craig Walls");
//        book.setGenre("Programming");
//        bookRepository.save(book);
//        System.out.println("Book saved to the database!");
    }
}
    
