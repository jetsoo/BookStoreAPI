package com.example.BookStore.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/book")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {

        this.bookService = bookService;
    }

    //BASEPATH
    @GetMapping
    public Iterable<Book> getAllBooks(){

        return this.bookService.getAll();
    }
    @GetMapping("/{id}")
    public Book getById(@PathVariable("id") Integer id){
        return this.bookService.getById(id);
    }

    @PostMapping
    public void addNewBook(@RequestBody Book book){
        this.bookService.addBook(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@RequestBody Book book, Integer id){
        return this.bookService.updateBookById(book,id);
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable("id") Integer id){
        this.bookService.deleteBook(id);
    }

    @GetMapping("/searchAll")
    public List<Book> searchAll(@RequestParam(required = false) String authorName,
                                @RequestParam(required = false) String bookName,
                                @RequestParam(required = false) String genre,
                                @RequestParam(required = false) Integer releaseYear){
        return this.bookService.searchAll(authorName,bookName,genre,releaseYear);
    }

    @GetMapping("/minRating")
    public List<Book> getBooksByMinRating(@RequestParam(name ="minRating") Integer minRating){
        return this.bookService.getByMinRating(minRating);
    }

    @PutMapping("/{id}/{rating}")
    public void setRating(@PathVariable("id") Integer id, @PathVariable("rating") Float rating){
        this.bookService.setRating(id,rating);
    }

    @GetMapping("/reducedPrice/{id}")
    public Float getReducedPrice(@PathVariable("id") Integer id){
        return this.bookService.getReducedPrice(id);
    }

}
