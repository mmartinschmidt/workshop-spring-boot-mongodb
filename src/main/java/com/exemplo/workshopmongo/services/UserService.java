package com.exemplo.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo.workshopmongo.domain.User;
import com.exemplo.workshopmongo.repository.UserRepository;
import com.exemplo.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		
		//User user = repo.findOne(id);
		//if (user == null) {
		//	throw new ObjectNotFoundException("Objeto não encontrado");
		//}
		//return user;
		
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	
	}
	
}
