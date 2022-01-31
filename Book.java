package com.example.BookStore.Book;


import javax.persistence.*;

@Entity
@Table(name ="BOOK")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "AUTHOR")
    private String authorName;
    @Column(name = "NAME")
    private String bookName;
    @Column(name = "RELEASE")
    private Integer releaseYear;
    @Column(name = "PRICE")
    private Float price;
    @Column(name = "GENRE")
    private String genre;
    @Column(name = "RATING")
    private Float rating;

    public Book() {
    }

    public Book(Integer id, String authorName, String bookName, Integer releaseYear, Float price, String genre, Float rating) {
        this.id = id;
        this.authorName = authorName;
        this.bookName = bookName;
        this.releaseYear = releaseYear;
        this.price = price;
        this.genre = genre;
        this.rating = rating;
    }

    public Book(String authorName, String bookName, Integer releaseYear, Float price, String genre, Float rating) {
        this.authorName = authorName;
        this.bookName = bookName;
        this.releaseYear = releaseYear;
        this.price = price;
        this.genre = genre;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                ", bookName='" + bookName + '\'' +
                ", releaseYear=" + releaseYear +
                ", price=" + price +
                ", genre=" + genre +
                ", rating=" + rating +
                '}';
    }
}
