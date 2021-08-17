package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.Entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long>{

}
