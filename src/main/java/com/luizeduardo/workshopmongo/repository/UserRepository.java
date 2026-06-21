package com.luizeduardo.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.luizeduardo.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {//user é o tipo da classse de domino que sera gerenciada, e o segudo e o tipo do ID

}
