package com.luizeduardo.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luizeduardo.workshopmongo.domain.User;
import com.luizeduardo.workshopmongo.dto.UserDTO;
import com.luizeduardo.workshopmongo.repository.UserRepository;
import com.luizeduardo.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;// é um mecanismo de injenção do spring boot e de intacniar 
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repo.findById(id);
		if (!user.isPresent()){
			throw new ObjectNotFoundException("Object not found");
		}
		return user.get();
	}
	
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	public void delete(String id) {
		User obj = findById(id);
		repo.delete(obj);
	}
	public User fromDto(UserDTO objdto) {
		return new User(objdto.getId(), objdto.getName(),objdto.getEmail());
	}
	
}
