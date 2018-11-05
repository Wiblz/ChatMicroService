package com.chat.chat;

import java.math.BigDecimal;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ChatController {
	  @Autowired
	  private Environment environment;
	  
	  @Autowired
	  private MessegeRepository messegeRepository;
	  
	  @GetMapping("/dialog/aquire/service/{servise_id}/customer/{customer_id}")
	  public List<Messege>  retrieveMesseges
	    (@PathVariable Long servise_id, @PathVariable Long customer_id){
		  		    
		    List<Messege> messeges = messegeRepository.findByServiceIdAndCustomerId(servise_id, customer_id);
		    return messeges;
	  }	 
	  
	  @PostMapping("/dialog/save")
	  public ResponseEntity<Object> createStudent(@RequestBody Messege messege){
		messege.setTime(LocalDateTime.now());
		Messege savedMessege = messegeRepository.save(messege);
	  	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
	  			.buildAndExpand(savedMessege.getId()).toUri();
	  	return ResponseEntity.created(location).build();
	  }
	  
	  @GetMapping("/dialog/aquire/all")
	  public List<Messege> retrieveAllMesseges(){
		    List<Messege> messeges = (List<Messege>) messegeRepository.findAll();
		    return messeges;
	  }	 
}
