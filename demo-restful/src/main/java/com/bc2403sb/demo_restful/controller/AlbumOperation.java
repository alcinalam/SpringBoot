package com.bc2403sb.demo_restful.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.bc2403sb.demo_restful.dto.respDto.AlbumDTO;

public interface AlbumOperation {
  
  @GetMapping(value = "/jsonplaceholder/albums")
  List<AlbumDTO> getAlbums();
}
