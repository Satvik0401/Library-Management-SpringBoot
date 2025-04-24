package com.Library.app;

//import org.springframework.boot.autoconfigure.domain.EntityScan;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//Jakarta is JAVA EE and Persistence is a package which is used to run SQL queries through IDE using java

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    @NotBlank(message="Title cannot be empty")
    @Size(min=2, message="Title should be greater than 2" )
    private String title;
    @NotBlank(message="Title cannot be empty")
    @Size(min=2, message="Title should be greater than 2" )
    private String author;
    private String genre;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
}


