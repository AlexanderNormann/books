package com.example.bookstore.service;

import com.example.bookstore.model.Book;

import java.util.List;

public interface BookService {
  List<Book> getAllBooks();
  void saveBook(Book book);
  Book getBookById(long id);
  void deleteBookById( long id);

}
