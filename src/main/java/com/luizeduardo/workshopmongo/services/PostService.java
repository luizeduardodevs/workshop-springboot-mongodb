package com.luizeduardo.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luizeduardo.workshopmongo.domain.Post;
import com.luizeduardo.workshopmongo.repository.PostRepository;
import com.luizeduardo.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;// é um mecanismo de injenção do spring boot e de intacniar 
	
	public Post findById(String id) {
		Optional<Post> post = repo.findById(id);
		if (!post.isPresent()){
			throw new ObjectNotFoundException("Object not founds");
		}
		return post.get();
	}
	
	public List<Post> findByTitle(String text)	{
		return repo.findByTitleContaining(text);
	}
}
