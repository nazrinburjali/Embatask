package com.embatask.productmanagement.repository;
import com.embatask.productmanagement.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
    User findByUserEmail(String email);
}


