package com.bc2403sb.demo_sb_dto;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.bc2403sb.demo_sb_dto.config.AppConfig;
import com.bc2403sb.demo_sb_dto.controller.impl.StockController;


// Test Environment
@SpringBootTest
// 1. Test @SpringBootApplication -> @ComponentScan -> Spring Context -> Server Start
// 2. 100% simulating the actual @SpringBootApplication env.
class DemoSbDtoApplicationTests {

  @Autowired
  private AppConfig appConfig;

  @Autowired
  private StockController stockController;

  @Test
  void contextLoads() {

  }

}
