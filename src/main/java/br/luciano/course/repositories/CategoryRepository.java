package br.luciano.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.luciano.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
