package com.luizeduardo.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.luizeduardo.workshopmongo.domain.Post;
import com.luizeduardo.workshopmongo.domain.User;
import com.luizeduardo.workshopmongo.dto.UserDTO;
import com.luizeduardo.workshopmongo.services.UserService;


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
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO objdto) {//vai retornar um objto vazio, o endpoint recebe como argumento o userdto, e pra aceitar esse argumento usa request body
		User obj = service.fromDto(objdto);//converteu o dto para user
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();//vai pegar o endereço do novo objeto que foi inserido
		return ResponseEntity.created(uri).build();//created retorna 201, contendo a localização do contéudo criado
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {//responseentity encapsula toda uma estrutura necessaria pra retornar uma reposta http
		service.delete(id);
		return ResponseEntity.noContent().build();//.ok instancia o response entity ja com o codigo de reposta
		//.body quer o corpo da resposta
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody UserDTO objdto,@PathVariable String id) {//vai retornar um objto vazio, o endpoint recebe como argumento o userdto, e pra aceitar esse argumento usa request body
		User obj = service.fromDto(objdto);//converteu o dto para user
		obj.setId(id);//garante que oo meu oj vai ter o id do argumento 
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/{id}/posts")
	public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {//responseentity encapsula toda uma estrutura necessaria pra retornar uma reposta http
		User obj = service.findById(id);
		return ResponseEntity.ok().body((obj.getPosts()));//.ok instancia o response entity ja com o codigo de reposta
		//.body quer o corpo da resposta
	}
	
}
