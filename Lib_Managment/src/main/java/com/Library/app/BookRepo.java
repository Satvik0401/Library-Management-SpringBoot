package com.Library.app;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository 
public interface BookRepo extends JpaRepository<Book, Integer> 
{
	List<Book> findByTitleContainingOrAuthorContainingOrGenreContaining(String title, String author, String genre);
}

