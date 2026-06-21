package com.luizeduardo.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luizeduardo.workshopmongo.domain.User;
import com.luizeduardo.workshopmongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;// é um mecanismo de injenção do spring boot e de intacniar 
	
	public List<User> findAll(){
		return repo.findAll();
	}
}
