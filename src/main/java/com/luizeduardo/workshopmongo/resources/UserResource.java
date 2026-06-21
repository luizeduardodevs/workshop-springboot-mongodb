package com.luizeduardo.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luizeduardo.workshopmongo.domain.User;
import com.luizeduardo.workshopmongo.dto.UserDTO;
import com.luizeduardo.workshopmongo.services.UserService;

import ch.qos.logback.core.joran.spi.HttpUtil.RequestMethod;


@RestController
@RequestMapping(value="/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	//@RequestMapping(method=RequestMethod.GET)
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {//responseentity encapsula toda uma estrutura necessaria pra retornar uma reposta http
		List<User> list = service.findAll();// vai la no banco de dados e vai guardar debtro dessa lista, e depois devolve a lista com a linha debaixo 
		List<UserDTO> dto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());//passando todos os valores da list pra dentro do valor x que vai ficar dentro da nova list dto.
		return ResponseEntity.ok().body(dto);//.ok instancia o response entity ja com o codigo de reposta
		//.body quer o corpo da resposta
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {//responseentity encapsula toda uma estrutura necessaria pra retornar uma reposta http
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));//.ok instancia o response entity ja com o codigo de reposta
		//.body quer o corpo da resposta
	}
}
