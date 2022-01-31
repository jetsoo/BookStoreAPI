package com.example.BookStore.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {


    Optional<Book> findBookByBookName(String bookName);
    List<Book> findByAuthorNameAndBookNameAndGenreAndReleaseYear(String authorName,String bookName,
                                                                 String genre,Integer releaseYear);
    List<Book> findByAuthorNameAndBookNameAndGenre(String authorName,String bookName,
                                                   String genre);
    List<Book> findByAuthorNameAndGenreAndReleaseYear(String authorName,String genre,Integer releaseYear);
    List<Book> findByAuthorNameAndBookName(String authorName,String bookName);
    List<Book> findByAuthorNameAndGenre(String authorName,String genre);
    List<Book> findByAuthorNameAndReleaseYear(String authorName,Integer releaseYear);
    List<Book> findByAuthorName(String authorName);
    List<Book> findByBookNameAndGenreAndReleaseYear(String bookName,String genre,Integer releaseYear);
    List<Book> findByBookNameAndGenre(String bookName,String genre);
    List<Book> findByBookNameAndReleaseYear(String bookName,Integer releaseYear);
    List<Book> findByBookName(String bookName);
    List<Book> findByGenreAndReleaseYear(String genre,Integer releaseYear);
    List<Book> findByGenre(String genre);
    List<Book> findByReleaseYear(Integer releaseYear);
    List<Book> findByRatingGreaterThan(Integer minRating);
}
