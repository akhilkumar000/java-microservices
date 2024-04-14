package org.example.ebookstoreapp2.controller;

import org.example.ebookstoreapp2.entities.Book;
import org.example.ebookstoreapp2.repositories.BookStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController

public class BookStoreRestController {
    @Autowired
    private BookStoreRepository bookStoreRepository;
    @GetMapping("/books")
    public ResponseEntity<List<Book>> findAllBooks(){
        try {
            List<Book> bookList=new ArrayList<>();
            bookStoreRepository.findAll().forEach(bookList::add);
            if(bookList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return  new ResponseEntity<>(bookList,HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getBookById/{id}")
    public  ResponseEntity<Book> findAllBooksById(@PathVariable int id){
        Optional<Book> bookData=bookStoreRepository.findById(id);
        if(bookData.isPresent()){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(bookData.get(), HttpStatus.NOT_FOUND);
    }
    @PostMapping("/addBook")
    public  ResponseEntity<Book> addBook(@RequestBody Book book){
        Book bookObj=bookStoreRepository.save(book);
        return new ResponseEntity<>(bookObj,HttpStatus.OK);
    }
    @PostMapping("/updateBookById/{id}")
    public  ResponseEntity<Book> updateBook(@PathVariable int id,@RequestBody Book newBookData){
        Optional<Book>oldBookData=bookStoreRepository.findById(id);
        if(oldBookData.isPresent()){
           Book updatedBookData= oldBookData.get();
           updatedBookData.setTitle(newBookData.getTitle());
           updatedBookData.setAuthor(newBookData.getAuthor());
           updatedBookData.setPages(newBookData.getPages());

          Book bookObj= bookStoreRepository.save(updatedBookData);
          return new ResponseEntity<>(bookObj,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable int id){
        bookStoreRepository.deleteById(id);
        return new ResponseEntity<>("Deleted Successfull",HttpStatus.OK);
    }

    @GetMapping("/getBookByTitle/{title}")
    public  ResponseEntity<List<Book>> findAllBooksByTitle(@PathVariable String title){
        List<Book> bookData=bookStoreRepository.findAllBooksByTitle(title);
        return new ResponseEntity<>(bookData,HttpStatus.OK);
    }
    @GetMapping("/getBookByAuthor/{author}")
    public  ResponseEntity<List<Book>> findAllBooksByAuthor(@PathVariable String author){
        List<Book> bookData=bookStoreRepository.findAllBooksByAuthor(author);
        return new ResponseEntity<>(bookData,HttpStatus.OK);
    }
}
