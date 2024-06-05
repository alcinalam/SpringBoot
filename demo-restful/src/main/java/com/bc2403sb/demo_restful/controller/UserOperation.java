package com.bc2403sb.demo_restful.controller;

import java.util.List;
import org.springframework.boot.autoconfigure.condition.ConditionalOnCheckpointRestore;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.bc2403sb.demo_restful.dto.reqDto.UserReqDTO;
import com.bc2403sb.demo_restful.dto.respDto.UserDTO;
import com.bc2403sb.demo_restful.entity.UserEntity;
import com.bc2403sb.demo_restful.infra.ApiResp;



public interface UserOperation {
  @GetMapping(value = "/jsonplaceholder/users")
  List<UserDTO> getUsers();

  @PostMapping(value = "/user")
  UserEntity saveUser(@RequestBody UserEntity user);

  @DeleteMapping(value = "/user")
  UserEntity deleteUser(@RequestParam Long id);

  // similar to SQL "update users where id=?"
  // if id exists, update the user, return the updated user object
  // if id not exists, update nothing, return NotFoundException
  // @PutMapping (value = "/user")
  // UserEntity updateUser(@RequestParam Long id, @RequestBody UserEntity user);

  // Get user by Id
  // Get user<User> by phone
  // Get List<User> by lat and long
  
  @PatchMapping(value = "/user/email")
  UserEntity updateUserEmailByid(@RequestParam Long id,
    @RequestBody UserReqDTO userReqDTO);

}
