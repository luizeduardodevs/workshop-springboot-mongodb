package com.luizeduardo.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.luizeduardo.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {//user é o tipo da classse de domino que sera gerenciada, e o segudo e o tipo do ID
	// campo que sera efetuado a busca,valor do parametro que eu quero,opçoes que voce que i=caseinsesitivi
	//@Query("{ <field>: { $regex: /pattern/, $options: '<options>' } }")
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);
	
	List <Post> findByTitleContainingIgnoreCase(String text);//ignorecase e feito pro case sensitive

}
