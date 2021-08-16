package com.product.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.Entity.Branch;

public interface BranchRepository extends JpaRepository<Branch, Long> {

}
