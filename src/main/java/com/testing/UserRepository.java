package com.testing;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

/**
 * Created by pabloyokese on 5/29/2017.
 */
@Repository
public interface UserRepository extends CustomRepository<User,String>{
    User findByEmail(String email);
    Long countByEmail(String email);
    Page<User> findByEmailContaining(String email,Pageable pageable);
}
