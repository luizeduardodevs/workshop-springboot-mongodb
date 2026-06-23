package com.luizeduardo.workshopmongo.dto;

import java.io.Serializable;

import com.luizeduardo.workshopmongo.domain.User;

public class AuthorDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	
	private AuthorDTO() {}
	public AuthorDTO(User obj) {//retorna um objeto do tipo user, pra ter uma forma automatizada pra instanciar o user a partir do userDTO
		super();
		this.id = obj.getId();
		this.name = obj.getName();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
