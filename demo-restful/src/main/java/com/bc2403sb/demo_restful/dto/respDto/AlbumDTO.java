package com.bc2403sb.demo_restful.dto.respDto;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class AlbumDTO {
  private int userId;
  private int albumId;
  private String albumName;


}
