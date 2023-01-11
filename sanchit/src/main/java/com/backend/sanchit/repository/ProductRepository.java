package com.backend.sanchit.repository;

import com.backend.sanchit.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
