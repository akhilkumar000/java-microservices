package org.example.ebookstoreapp2.repositories;

import org.example.ebookstoreapp2.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookStoreRepository extends JpaRepository<Book,Integer> {
    List<Book> findAllBooksByTitle(String title);
    List<Book> findAllBooksByAuthor(String author);

}
