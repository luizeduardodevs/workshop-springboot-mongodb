package com.luizeduardo.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.luizeduardo.workshopmongo.domain.Post;
import com.luizeduardo.workshopmongo.domain.User;
import com.luizeduardo.workshopmongo.dto.AuthorDTO;
import com.luizeduardo.workshopmongo.dto.CommentDTO;
import com.luizeduardo.workshopmongo.repository.PostRepository;
import com.luizeduardo.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		postRepository.deleteAll();
		userRepository.deleteAll();//isso vai limpar a collecão la dentro do mongo db
		//depois vai salvar esse tres instanciados 
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Greyss", "bob@gmail.com"); 
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		
		Post post1 = new Post(null,sdf.parse("21/03/2022"),"Let´s go travel","I´m Traveling from São Paulo",new AuthorDTO(maria));
		Post post2 = new Post(null,sdf.parse("22/03/2022"),"Good morning","I woke up very happy", new AuthorDTO(maria)); 
		
		CommentDTO c1 = new CommentDTO("Good travel", sdf.parse("21/03/2022"), new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(c1));
		postRepository.saveAll(Arrays.asList(post1,post2));
		maria.getPosts().addAll(Arrays.asList(post1,post2));
		userRepository.save(maria);
		
		
	}

}
