package br.luciano.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.luciano.course.entities.User;
import br.luciano.course.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
}
