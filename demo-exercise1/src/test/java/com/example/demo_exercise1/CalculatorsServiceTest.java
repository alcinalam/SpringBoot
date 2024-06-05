package com.example.demo_exercise1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo_exercise1.service.CalculatorService;

@SpringBootTest
public class CalculatorsServiceTest {


  @Autowired
  private CalculatorService calculatorService;

  @Test
  void testResult() {
    assertEquals("6.6", calculatorService.getResult("3.3","3.3","add"));
    assertEquals("3.3", calculatorService.getResult("6.6","3.3","sub"));
    assertEquals("10.89", calculatorService.getResult("3.3","3.3","mul"));
    assertEquals("3.14286", calculatorService.getResult("22","7","div"));
    assertThrows(ArithmeticException.class,()-> calculatorService.getResult("7","0","div"));
  }

  @Test
  void testCal() {
    assertEquals(6.6, calculatorService.add("3.3","3.3"));
    assertEquals(3.3, calculatorService.sub("6.6","3.3"));
    assertEquals(10.89, calculatorService.mul("3.3","3.3"));
    assertEquals(3.14286, calculatorService.div("22","7"));
    assertEquals(1, calculatorService.div("3.3","3.3"));
    assertThrows(ArithmeticException.class,()-> calculatorService.div("7","0"));
    assertThrows(NumberFormatException.class,()-> calculatorService.div("abc","1"));
    assertThrows(NumberFormatException.class,()-> calculatorService.div("1","abc"));
  }

}
