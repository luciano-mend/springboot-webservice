package br.luciano.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.luciano.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
