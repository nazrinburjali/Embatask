package com.embatask.productmanagement.repository;
import com.embatask.productmanagement.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {

    User findByUserEmail(String email);
    Optional<String> getUserByUserEmail(String email);

}


