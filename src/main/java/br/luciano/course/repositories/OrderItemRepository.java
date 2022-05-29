package br.luciano.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.luciano.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
