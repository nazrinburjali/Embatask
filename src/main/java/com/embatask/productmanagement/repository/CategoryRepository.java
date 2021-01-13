package com.embatask.productmanagement.repository;

import com.embatask.productmanagement.domain.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, Integer> {
    @Query(value = "select c from Category c where c.parentCategoryID is not null  and c.parentCategoryID<>2")
    List<Category> findAllSubCategories();
}
