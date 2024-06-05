package com.bc2403sb.bc_forum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.bc2403sb.bc_forum.dto.respDto.UserDTO;

public  interface UserOperation {
  @GetMapping(value = "/jsonplaceholder/users")
  List<UserDTO> getUsers();

  

}
