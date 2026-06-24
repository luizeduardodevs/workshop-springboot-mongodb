package com.luizeduardo.workshopmongo.repository;

import java.util.Date;
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
	//os dois sao para a mesma coisa coisa
	List <Post> findByTitleContainingIgnoreCase(String text);//ignorecase e feito pro case sensitive

	//consulta de string por entre datas
	@Query("{ $and: [ {date: { $gte: ?1}}, {date: { $lte: ?2 }} , { $or: [ { 'title': { $regex: ?0, $options: 'i'  }}, { 'body': { $regex: ?0, $options: 'i' }},{ 'comments.text': { $regex: ?0, $options: 'i'}} ] } ] }")
	List<Post> fullSearch(String text,Date minDate, Date maxDate);
}
