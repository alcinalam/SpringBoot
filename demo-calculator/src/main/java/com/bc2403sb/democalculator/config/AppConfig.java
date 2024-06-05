package com.bc2403sb.democalculator.config;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.bc2403sb.democalculator.model.Cat;
import com.bc2403sb.democalculator.model.Color;

@Configuration
public class AppConfig {
  
  public String sayHello(){
    return"hello";
  }

    // Create an object (bean), and then put it into spring context
  @Bean(name = "white") // create the bean by defined name 
  Cat createWhiteCat() {
    return new Cat("ABC", 3, List.of(Color.WHITE));
  }

  @Bean(name = "yellow") // create the bean by defined name
  // @Primary // Approach 1
  Cat createYellowCat() {
    return new Cat("DEF", 4, List.of(Color.YELLOW));
  }
}
