package com.luizeduardo.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.luizeduardo.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {//user é o tipo da classse de domino que sera gerenciada, e o segudo e o tipo do ID

	List <Post> findByTitleContainingIgnoreCase(String text);

}
