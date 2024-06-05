package com.bc2403sb.demo_restful.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bc2403sb.demo_restful.controller.AlbumOperation;
import com.bc2403sb.demo_restful.dto.respDto.AlbumDTO;
import com.bc2403sb.demo_restful.mapper.AlbumMapper;
import com.bc2403sb.demo_restful.service.AlbumService;

@RestController
public class AlbumController implements AlbumOperation {
  
  @Autowired
  private AlbumService albumService;

  @Autowired
  private AlbumMapper mapper;

  @Override
  public List<AlbumDTO> getAlbums() {
    return albumService.getAlbums().stream() //
      .map(e->mapper.albumToMap(e)) //
      .collect(Collectors.toList());
  }

  
}
