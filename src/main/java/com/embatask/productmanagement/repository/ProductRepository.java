package com.embatask.productmanagement.repository;

import com.embatask.productmanagement.domain.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
}
