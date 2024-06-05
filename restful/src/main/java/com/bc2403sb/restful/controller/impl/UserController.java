package com.bc2403sb.restful.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bc2403sb.restful.controller.UserOperation;
import com.bc2403sb.restful.dto.reqDto.UserReqDTO;
import com.bc2403sb.restful.dto.respDto.UserDTO;
import com.bc2403sb.restful.entity.UserEntity;
import com.bc2403sb.restful.mapper.UserMapper;
import com.bc2403sb.restful.service.UserService;

@RestController
public class UserController implements UserOperation{
  @Autowired
  private UserService userService;

  @Autowired
  private UserMapper mapper;

  @Override
  public List<UserDTO> getUsers() {
    return userService.getUsers().stream() //
        .map(e -> mapper.map(e)) //
        .collect(Collectors.toList());
  }

  @Override
  public UserEntity saveUser(UserEntity user) {
    if (user.getPhone() == null)
      throw new RuntimeException(); // GlobalExceptionHandler
    return userService.save(user);
  }

  // @Override
  // public UserEntity deleteUser(Long id) {
  //   return userService.deleteById(id);
  // }

  // @Override
  // public UserEntity updateUserEmailById(Long id, UserReqDTO userReqDTO) {
  //   return userService.updateEmailById(id, userReqDTO);
  // }
}
