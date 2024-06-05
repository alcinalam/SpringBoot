package com.bc2403sb.demo_restful.controller.impl;

import java.util.List;
import com.bc2403sb.demo_restful.model.dto.User;
import com.bc2403sb.demo_restful.service.UserService;
import io.micrometer.common.lang.NonNull;

/**
 * Difference between Spring and Java (the way to manage the depenedency)
 */
public class TestController {

  private UserService userService;

  public TestController(@NonNull UserService userService) throws Exception {
    // if (userService == null)
    //   throw new Exception();
    this.userService = userService;
  }

  public List<User> test() {
    return this.userService.getUsers();
  }

  public static void main(String[] args) {
    TestController testController = null;
    try {
      testController = new TestController(null);
    } catch (Exception e) {
    }
    testController.test(); // NPE
  }

}
