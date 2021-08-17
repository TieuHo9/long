package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.Entity.Orders;



public interface OrdersRepository extends JpaRepository<Orders, Long>{

}
