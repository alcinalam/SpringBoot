package com.bc2403sb.demo_restful.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bc2403sb.demo_restful.infra.Scheme;
import com.bc2403sb.demo_restful.model.dto.Album;
import com.bc2403sb.demo_restful.service.AlbumService;

@Service
public class AlbumServiceimpl implements AlbumService {

  @Value(value = "${api.json-place-holder.domain}")
  private String domain;

  @Value(value = "${api.json-place-holder.endpoints.albums}")
  private String albumsEndpoint;

  @Autowired RestTemplate restTemplate;

  @Override
  public List<Album> getAlbums() {

    String url = UriComponentsBuilder.newInstance() //
        .scheme(Scheme.HTTPS.lowercase()) //
        .host(this.domain)
        .path(albumsEndpoint) //
        .toUriString(); 
    
    Album[] albums = restTemplate.getForObject(url,Album[].class);
  
    return Arrays.asList(albums);
    

  }
  
}
