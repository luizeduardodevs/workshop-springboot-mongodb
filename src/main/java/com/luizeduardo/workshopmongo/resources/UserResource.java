package com.luizeduardo.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luizeduardo.workshopmongo.domain.User;
import com.luizeduardo.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	//@RequestMapping(method=RequestMethod.GET)
	@GetMapping
	public ResponseEntity<List<User>> findAll() {//responseentity encapsula toda uma estrutura necessaria pra retornar uma reposta http
		List<User> list = service.findAll();// vai la no banco de dados e vai guardar debtro dessa lista, e depois devolve a lista com a linha debaixo 
		return ResponseEntity.ok().body(list);//.ok instancia o response entity ja com o codigo de reposta
		//.body quer o corpo da resposta
	}
}
