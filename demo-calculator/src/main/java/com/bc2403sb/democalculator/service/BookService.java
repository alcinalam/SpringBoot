package com.bc2403sb.democalculator.service;

import java.util.Map;
import com.bc2403sb.democalculator.model.Book;

public interface BookService {
  
  Book getBook (String author);
  Map<Long, Book> getBookMap();
}
