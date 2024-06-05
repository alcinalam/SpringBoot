package com.bc2403sb.democalculator.controller.impl;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;
import com.bc2403sb.democalculator.controller.BookOperation;
import com.bc2403sb.democalculator.model.Book;
import com.bc2403sb.democalculator.service.BookService;

@RestController //Controller + ResponseBody
public class BookController implements BookOperation {

  // Controller layer should not contain business logic
  // for example, the way to "find a book by anthor" is a business logic

  // Controller -> call service layer

  @Autowired
  @Qualifier(value = "bookServiceFromDatabaseimpl")
  private BookService bookServiceFromDatabase;

  @Autowired
  @Qualifier(value = "bookServiceFromMemoryimpl")
  private BookService bookServiceFromMemory;

  @Override
  public Book getBook(String author) {
    return bookServiceFromDatabase.getBook(author);
  }

  @Override
  public LocalDate getBookPublishDate(String author) {
    // return new BookServiceImpl().getBook(author);
    Book book;
    int x = 7;
    if (x > 5)
      book = bookServiceFromDatabase.getBook(author);
    else
      book = bookServiceFromMemory.getBook(author);
    // return book.getAuthor().concat("-").concat(book.getPublishDate().toString());
    return book.getPublishDate();
  
  }
  
}
