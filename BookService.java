package com.example.BookStore.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //BASEPATH
    public Iterable<Book> getAll(){
        return this.bookRepository.findAll();
    }
    //CREATE
    public void addBook(Book book){
        Optional<Book> bookOptional = this.bookRepository.findBookByBookName(book.getBookName());
        if(bookOptional.isPresent()){
            throw new IllegalStateException("bookname already taken");
        }
        this.bookRepository.save(book);
    }
    //UPDATE
    public Book updateBookById(Book book, Integer id){
        Optional<Book> bookOptional = this.bookRepository.findById(id);
        if(!bookOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no book with this id exists currently");
        }
        Book bookToUpdate = bookOptional.get();
        bookToUpdate = book;
        return this.bookRepository.save(bookToUpdate);

    }
    //DELETE BY ID
    public void deleteBook(Integer id){
        Optional<Book> bookOptional = this.bookRepository.findById(id);
        if(!bookOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no book with this id exists currently");
        }
        Book bookToDelete = bookOptional.get();
        this.bookRepository.delete(bookToDelete);
    }

    //BY ID
    public Book getById(Integer id){
       Optional<Book> bookOptional = this.bookRepository.findById(id);
       if(!bookOptional.isPresent()){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no book with this id exists currently");
       }
       Book book = bookOptional.get();
       return book;
    }



    //MIN RATING
    public List<Book> getByMinRating(Integer minRating) {
        return this.bookRepository.findByRatingGreaterThan(minRating);
    }

    //SET RATING BY ID
    public void setRating(Integer id,Float rating){
        Optional<Book> bookOptional = this.bookRepository.findById(id);
        if(!bookOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no book with this id exists currently");
        }
        Book book = bookOptional.get();
        book.setRating(rating);
        this.bookRepository.save(book);
    }
    //GET REDUCED PRICE BY 20 % BY ID
    public Float getReducedPrice(Integer id){
        Optional<Book> bookOptional = this.bookRepository.findById(id);
        if(!bookOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no book with this id exists currently");
        }
        Book book = bookOptional.get();
        Float reducedPrice = (book.getPrice() /100) * 80;
        return reducedPrice;
    }

    //SEARCH ALL
    public List<Book> searchAll(String authorName, String bookName, String genre, Integer releaseYear) {
        if(authorName != null){
            if(bookName != null && genre != null && releaseYear != null){
                return bookRepository.findByAuthorNameAndBookNameAndGenreAndReleaseYear(authorName, bookName, genre, releaseYear);
            }
            else if(bookName != null && genre != null){
                return this.bookRepository.findByAuthorNameAndBookNameAndGenre(authorName, bookName, genre);
            }
            else if(genre != null && bookName != null){
                return this.bookRepository.findByAuthorNameAndGenreAndReleaseYear(authorName, genre, releaseYear);
            }
            else if(bookName != null){
                return this.bookRepository.findByAuthorNameAndBookName(authorName, bookName);
            }
            else if(genre != null){
                return this.bookRepository.findByAuthorNameAndGenre(authorName, genre);
            }
            else if(releaseYear != null){
                return this.bookRepository.findByAuthorNameAndReleaseYear(authorName, releaseYear);
            }
            else {
                return this.bookRepository.findByAuthorName(authorName);
            }
        }
        else if(bookName != null){
            if(genre != null && releaseYear != null){
                return this.bookRepository.findByBookNameAndGenreAndReleaseYear(bookName, genre, releaseYear);
            }
            else if(genre != null){
                return this.bookRepository.findByBookNameAndGenre(bookName, genre);
            }
            else if(releaseYear != null){
                return this.bookRepository.findByBookNameAndReleaseYear(bookName, releaseYear);
            }
            else {
                return this.bookRepository.findByBookName(bookName);
            }

        }
        else if(genre != null && releaseYear != null){
            return this.bookRepository.findByGenreAndReleaseYear(genre, releaseYear);
        }
        else if(genre != null){
            return this.bookRepository.findByGenre(genre);
        }
        else if(releaseYear != null){
            return this.bookRepository.findByReleaseYear(releaseYear);
        }
        else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"need to enter some information");
        }
    }
}
