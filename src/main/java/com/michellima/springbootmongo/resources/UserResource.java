package com.michellima.springbootmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.michellima.springbootmongo.domain.User;
import com.michellima.springbootmongo.dto.UserDTO;
import com.michellima.springbootmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll(){
		
		//User maria = new User("1", "Maria Silva", "maria@gmail.com");
		//User alex = new User("2", "Alex Green", "alex@gmail.com");
		
		List<User> list = service.finAll();
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		
		
		//list.add(maria);
		//list.add(alex);
		//list.addAll(Arrays.asList(maria, alex));
		
		return ResponseEntity.ok().body(listDTO);
	}

}
