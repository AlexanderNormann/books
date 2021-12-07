package com.example.bookstore.controller;

import com.example.bookstore.model.Book;
import com.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {

  @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
  @Autowired
  private BookService bookService;

  @GetMapping("/")
  public String viewHomePage(Model model){
    model.addAttribute("listOfBooks", bookService.getAllBooks());
    return "index";

  }
  @GetMapping("showAddBookForm")
  public String showAddBookForm(Model model){
    Book book = new Book();
    model.addAttribute("book", book);
    return  "new_book";

  }
  @PostMapping("/saveBook")
  public String saveBook(@ModelAttribute("book") Book book){
    bookService.saveBook(book);
    return "redirect:/";

  }
  @GetMapping("/showFormForUpdate/{id}")
  public String showFormForUpdate(@PathVariable(value = "id") long id, Model model){
    Book book = bookService.getBookById(id);
    model.addAttribute("book", book);
    return "update_book";
  }

  @GetMapping("/deleteBook/{id}")
  public String deleteBook (@PathVariable (value = "id") long id){
    this.bookService.deleteBookById(id);
    return "redirect:/";
  }
}
