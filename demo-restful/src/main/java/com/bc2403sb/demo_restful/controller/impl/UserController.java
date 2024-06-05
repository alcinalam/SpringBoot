package com.bc2403sb.demo_restful.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.web.bind.annotation.RestController;
import com.bc2403sb.demo_restful.controller.UserOperation;
import com.bc2403sb.demo_restful.dto.reqDto.UserReqDTO;
import com.bc2403sb.demo_restful.dto.respDto.UserDTO;
import com.bc2403sb.demo_restful.entity.UserEntity;

import com.bc2403sb.demo_restful.mapper.UserMapper;
import com.bc2403sb.demo_restful.service.UserService;


@RestController
//@RequestMapping(value = "/v1") // if you need another verion V2
public class UserController implements UserOperation {

  @Autowired
  //@Qualifier(value = "userService2") <--V2 can chose which beans to use
  private UserService userService;

  @Autowired
  private UserMapper mapper;

  @Override
  public List<UserDTO> getUsers() {
    return userService.getUsers().stream()//
      .map(e-> mapper.map(e)) //
      .collect(Collectors.toList());
  }

  @Override
  public UserEntity saveUser(UserEntity user) {
    return userService.save(user);
  }

  @Override
  public UserEntity deleteUser(Long id) {
    return userService.deleteById(id);
  }

  @Override
  public UserEntity updateUserEmailByid (Long id, UserReqDTO userReqDTO) {
    return userService.updateEmailById(id, userReqDTO);
  }

}
