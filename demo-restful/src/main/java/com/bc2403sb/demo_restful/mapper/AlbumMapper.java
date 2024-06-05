package com.bc2403sb.demo_restful.mapper;

import org.springframework.stereotype.Component;
import com.bc2403sb.demo_restful.dto.respDto.AlbumDTO;
import com.bc2403sb.demo_restful.model.dto.Album;

@Component
public class AlbumMapper {
  
  public AlbumDTO albumToMap (Album album) {

    return AlbumDTO.builder() //
      .userId(album.getUserId()) //
      .albumId(album.getId()) //
      .albumName(album.getTitle())//
      .build();
  }
}
