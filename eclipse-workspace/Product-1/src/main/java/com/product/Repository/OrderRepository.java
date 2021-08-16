package com.product.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.Entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
