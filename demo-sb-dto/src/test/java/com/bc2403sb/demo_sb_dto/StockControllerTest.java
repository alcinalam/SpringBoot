package com.bc2403sb.demo_sb_dto;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.bc2403sb.demo_sb_dto.controller.impl.StockController;
import com.bc2403sb.demo_sb_dto.dto.StockDTO;
import com.bc2403sb.demo_sb_dto.dto.mapper.StockMapper;
import com.bc2403sb.demo_sb_dto.model.Stock;
import com.bc2403sb.demo_sb_dto.service.StockService;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest(StockController.class)
// Create the spring context with web layer related beans ONLY
class StockControllerTest {

  
  // @Autowired
  // private StockController stockController;

  @MockBean
  private StockService stockService;

  @SpyBean
  private StockMapper stockMapper;

  @Autowired
  private MockMvc mockMvc;

  @Test
  void testGetStocks() throws Exception {
    Stock s1 = new Stock(5, "ABC", 1000);
    Stock s2 = new Stock(5, "ABC", 2000);
    Stock s3 = new Stock(10, "DEF", 20000);

    Mockito.when(stockService.getAll())
        .thenReturn(new ArrayList<>(List.of(s1, s2, s3)));
    
    // Simulate a client make the web request
    mockMvc.perform(MockMvcRequestBuilders.get("/stocks")) //
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].stockNo", is(5)))
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].quantity", is(3000)))
        .andExpect(MockMvcResultMatchers.jsonPath("$[1].stockNo", is(10)))
        .andExpect(MockMvcResultMatchers.jsonPath("$[1].quantity", is(20000)));

    verify(stockService, times(1)).getAll();

    mockMvc.perform(get("/stocks"))
        .andExpect(jsonPath("$[*].stockNo").value(hasItem(5)))
        .andExpect(jsonPath("$[*].stockNo").value(hasItem(10)))
        .andExpect(jsonPath("$[*].quantity").value(hasItem(3000)))
        .andExpect(jsonPath("$[*].quantity").value(hasItem(20000)));
  }

  @Test
  void testGetStocks2() throws Exception {
    Stock s1 = new Stock(5, "ABC", 1000);
    Stock s2 = new Stock(5, "ABC", 2000);
    Stock s3 = new Stock(10, "DEF", 20000);

    Mockito.when(stockService.getAll())
        .thenReturn(new ArrayList<>(List.of(s1, s2, s3)));

    String json = mockMvc.perform(get("/stocks")).andReturn().getResponse()
        .getContentAsString();

    // Deserialize JSON (No Arg Constructor)
    StockDTO[] dtos = new ObjectMapper().readValue(json, StockDTO[].class);

    List<StockDTO> dtoList = Arrays.asList(dtos);

    assertThat(dtoList.stream() //
    .filter(e -> e.getStockNo() == 5) //
    .findAny() // Optional<>
    .get() //
    .getQuantity(), //
    is(3000));

    assertThat(dtoList.stream() //
        .filter(e -> e.getStockNo() == 10) //
        .findAny() //
        .get() //
        .getQuantity(), //
        is(20000));
    }

  


    // assertThat(dtoList, hasItem(new StockDTO(5, 3000)));
    // assertThat(dtoList, hasItem(new StockDTO(10, 20000)));
  
}