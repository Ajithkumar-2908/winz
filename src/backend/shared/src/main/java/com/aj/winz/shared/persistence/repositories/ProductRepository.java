package com.aj.winz.shared.persistence.repositories;

import com.aj.winz.shared.persistence.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
