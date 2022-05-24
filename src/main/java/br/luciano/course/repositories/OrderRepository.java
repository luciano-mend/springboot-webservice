package br.luciano.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.luciano.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
