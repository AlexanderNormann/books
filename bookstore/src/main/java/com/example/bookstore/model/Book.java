package com.example.bookstore.model;

import javax.persistence.*;

@Entity
@Table(name = "Books")

public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "book_name")
  private String bookName;

  @Column(name = "author")
  private String author;

  @Column(name = "book_number")
  private String bookNumber;

  public String getBookNumber() {
    return bookNumber;
  }

  public void setBookNumber(String bookNumber) {
    this.bookNumber = bookNumber;
  }



  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getBookName() {
    return bookName;
  }

  public void setBookName(String bookName) {
    this.bookName = bookName;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }



}
