package com.bc2403sb.democalculator.service.impl;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.bc2403sb.democalculator.model.Book;
import com.bc2403sb.democalculator.service.BookService;
import jakarta.annotation.PostConstruct;

@Service
public class BookServiceFromMemoryimpl implements BookService{
  
  private final Map<Long, Book> bookMap = new HashMap<>();

  @Override
  public Map<Long, Book> getBookMap() {
    return this.bookMap;
  }

  @PostConstruct // Right after creating bookController bean and before server start completed
  public void init() {
    Book book1 = new Book("Jenny", LocalDate.of(2000, 10, 1));
    Book book2 = new Book("Vincent", LocalDate.of(2010, 10, 1));
    Book book3 = new Book("Karson", LocalDate.of(2020, 10, 1));
    bookMap.put(book1.getId(), book1);
    bookMap.put(book2.getId(), book2);
    bookMap.put(book3.getId(), book3);
  }


   // return new Book(2, "Jenny Chan", LocalDate.of(2020, 1, 1));
  @Override
  public Book getBook(String author) {
    if (author == null)
      return null;
    return this.bookMap.values().stream()//
      .filter(e->e.getAuthor().equals(author))//
      .findFirst() // return book object
      .orElse(null);
  }
  
}
