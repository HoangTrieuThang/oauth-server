package com.k001.SpringBootAuth.repository;

import com.k001.SpringBootAuth.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);


    User findByEmail(String email);

}
