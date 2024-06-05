package com.bc2403sb.restful.service;

import java.util.List;
import com.bc2403sb.restful.dto.reqDto.UserReqDTO;
import com.bc2403sb.restful.entity.UserEntity;
import com.bc2403sb.restful.model.dto.User;

public interface UserService {
  List<User> getUsers();

  UserEntity save(UserEntity user);

  UserEntity deleteById(Long id);

  UserEntity findById(Long id);

  // Put
  UserEntity updateUser(Long id, UserEntity entity);

  // Patch
  UserEntity updateEmailById(Long id, UserReqDTO dto);
}
