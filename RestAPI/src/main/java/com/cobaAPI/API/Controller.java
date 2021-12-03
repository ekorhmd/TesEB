package com.cobaAPI.API;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/coba")
public class Controller {
    
  @Autowired
  private YoutubeService service;
  
  @GetMapping("/youtube")
  public List<Youtube>list(){
      return service.listAll();
  }
  
  @GetMapping("/youtube/{id}")
  public ResponseEntity <Youtube> get(@PathVariable String id){
      try{
          Youtube youtube = service.get(id);
          return new ResponseEntity<Youtube>(youtube, HttpStatus.OK);
      }catch (NoSuchElementException e){
          return new ResponseEntity<Youtube>(HttpStatus.NOT_FOUND);
      }
  }
  
  @PostMapping("/youtubes")
  public void add(@RequestBody Youtube youtube){
      service.save(youtube);
  }
  
  @PutMapping("/youtubes/{id}")
  public ResponseEntity<?> update(@RequestBody Youtube youtube,
          @PathVariable String id){
      try{
        Youtube existYoutube = service.get(id);
        service.save(youtube);
        return new ResponseEntity<>(HttpStatus.OK);
       }catch(NoSuchElementException e){
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);  
}
}
  @DeleteMapping("/youtubes/{id}")
  public void delete(@PathVariable String id){
      service.delete(id);
  }
}
  
