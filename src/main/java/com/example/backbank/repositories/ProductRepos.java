package com.example.backbank.repositories;

import com.example.backbank.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepos extends JpaRepository<Product,Long> {
}
