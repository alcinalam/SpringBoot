package com.bc2403sb.democalculator.controller;

import java.time.LocalDate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bc2403sb.democalculator.model.Book;


public interface BookOperation {

  @GetMapping (value = "/books")
  Book getBook(@RequestParam String author);

  @GetMapping (value = "/books/publishdate")
   LocalDate getBookPublishDate(@RequestParam String author);
}
