package com.bc2403sb.restful.mapper;

import org.springframework.stereotype.Component;
import com.bc2403sb.restful.dto.respDto.UserDTO;
import com.bc2403sb.restful.dto.respDto.UserDTO.AddressDTO;
import com.bc2403sb.restful.dto.respDto.UserDTO.AddressDTO.LocationDTO;
import com.bc2403sb.restful.dto.respDto.UserDTO.CompanyDTO;
import com.bc2403sb.restful.model.User;

@Component
public class UserMapper {


  public UserDTO map(User user) {
    LocationDTO locationDTO = LocationDTO.builder() //
        .latitude(user.getAddress().getGeo().getLatitude())
        .longitude(user.getAddress().getGeo().getLongitude()).build();

    AddressDTO addressDTO = AddressDTO.builder() //
        .city(user.getAddress().getCity()) //
        .street(user.getAddress().getStreet()) //
        .suite(user.getAddress().getSuite()) //
        .geo(locationDTO) //
        .build();

    CompanyDTO companyDTO = CompanyDTO.builder() //
        .name(user.getCompany().getName()) //
        .business(user.getCompany().getBusiness()) //
        .build();

    return UserDTO.builder() //
        .id(user.getId()) //
        .name(user.getName()) //
        .address(addressDTO) //
        .company(companyDTO) //
        .build();
  }
}

