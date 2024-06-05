package com.bc2403sb.restful.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bc2403sb.restful.dto.reqDto.UserReqDTO;
import com.bc2403sb.restful.dto.respDto.UserDTO;
import com.bc2403sb.restful.entity.UserEntity;
import com.bc2403sb.restful.model.User;

public interface UserOperation {

  @GetMapping(value = "/jsonplaceholder/users")
  List<UserDTO> getUsers();

  @PostMapping(value = "/user")
  UserEntity saveUser(@RequestBody UserEntity user);

  // @DeleteMapping(value = "/user")
  // UserEntity deleteUser(@RequestParam Long id);

  // @PatchMapping(value = "/user/email")
  // UserEntity updateUserEmailById(@RequestParam Long id,
  // @RequestBody UserReqDTO userReqDTO);


}
