package com.cobaAPI.API;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YoutubeService {
   @Autowired
   private Repository repo;
   
   public List<Youtube>listAll(){
       return repo.findAll();
   }
   
   public void save(Youtube youtube){
       repo.save(youtube);
   }
   
   public Youtube get (String id){
       return repo.findById(id).get();
   }
   public void delete(String id){
       repo.deleteById(id);
   }
}
