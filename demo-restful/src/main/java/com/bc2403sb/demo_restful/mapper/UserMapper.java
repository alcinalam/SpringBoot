package com.bc2403sb.demo_restful.mapper;

import org.springframework.stereotype.Component;
import com.bc2403sb.demo_restful.dto.respDto.UserDTO;
import com.bc2403sb.demo_restful.dto.respDto.UserDTO.AddressDTO;
import com.bc2403sb.demo_restful.dto.respDto.UserDTO.CompanyDTO;
import com.bc2403sb.demo_restful.dto.respDto.UserDTO.AddressDTO.LocationDTO;
import com.bc2403sb.demo_restful.model.dto.User;

@Component
public class UserMapper {

  // HSBCUserDTO -> User (model) -> UserEntity
  // GovUserDTO -> User (model) -> ThirdUserDTO -> call third Part API
  
  
  public UserDTO map(User user){

    LocationDTO locationDTO = LocationDTO.builder() //
      .latitude(user.getAddress().getGeo().getLatitude()) //
      .longitude(user.getAddress().getGeo().getLongitude())//
      .build();

    AddressDTO addressDTO = AddressDTO.builder() //
      .city(user.getAddress().getCity())
      .street(user.getAddress().getCity())//
      .suite(user.getAddress().getCity())//
      .geo(locationDTO)
      .build();

    CompanyDTO companyDTO = CompanyDTO.builder()//
      .name(user.getCompany().getName()) //
      .business(user.getCompany().getBusiness())//
      .build();

    
    return UserDTO.builder() //
      .id(user.getId()) //
      .name(user.getName())//
      .address(addressDTO)
      .company(companyDTO)//      
      .build();
  }
}
