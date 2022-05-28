package br.luciano.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.luciano.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
