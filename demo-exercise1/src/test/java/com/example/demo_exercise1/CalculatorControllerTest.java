package com.example.demo_exercise1;

import static org.mockito.ArgumentMatchers.any;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.example.demo_exercise1.controller.impl.CalculatorController;
import com.example.demo_exercise1.dto.CalculatorDTO;
import com.example.demo_exercise1.dto.mapper.CalculatorMapper;
import com.example.demo_exercise1.model.Calculator;
import com.example.demo_exercise1.service.CalculatorService;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.Matchers.*;


@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {
  
@MockBean
private CalculatorService calculatorService;

@MockBean
private CalculatorMapper calculatorMapper;

@SpyBean
private Calculator calculator;

@Autowired
private MockMvc mockMvc;

@Test
void testCalResult()throws Exception{

  given(calculatorService.getResult("3.3", "3.2", "div")).willReturn("1.03125");

  CalculatorDTO calculatorDTO = CalculatorDTO.builder()
          .x("3.3")
          .y("3.2")
          .op("div")
          .result("1.03125")
          .build();
  given(calculatorMapper.mapToCalculatorDTO(any())).willReturn(calculatorDTO);

  Mockito.when(calculatorService.getResult("3.3","3.2","div"))
    .thenReturn("1.03125");

  mockMvc.perform(MockMvcRequestBuilders.get("/calculate/{x}/{y}/{op}","3.3","3.2","div")) //
    .andExpect(status().isOk())
    .andExpect(jsonPath("$.x", is("3.3")))
    .andExpect(jsonPath("$.y", is("3.2")))
    .andExpect(jsonPath("$.op", is("div")))
    .andExpect(jsonPath("$.result", is("1.03125")));

}



}
