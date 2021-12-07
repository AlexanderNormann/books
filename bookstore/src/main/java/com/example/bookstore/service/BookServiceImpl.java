package com.example.bookstore.service;

import com.example.bookstore.model.Book;
import com.example.bookstore.respository.BookRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

  @Autowired
  private BookRespository bookRespository;

  @Override
  public List<Book> getAllBooks() {
    return bookRespository.findAll();
  }

  @Override
  public void saveBook(Book book) {
    this.bookRespository.save(book);
  }

  @Override
  public Book getBookById(long id) {
    Optional<Book> optional = bookRespository.findById(id);
    Book book = null;
    if (optional.isPresent()){
      book = optional.get();
    } else {
      throw  new RuntimeException("Book not found for id:: " + id);
    }
    return book;
  }

  @Override
  public void deleteBookById(long id) {
    this.bookRespository.deleteById(id);
  }
}
