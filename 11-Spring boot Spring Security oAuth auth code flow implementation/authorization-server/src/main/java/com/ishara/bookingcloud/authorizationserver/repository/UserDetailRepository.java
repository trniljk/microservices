package com.ishara.bookingcloud.authorizationserver.repository;

import com.ishara.bookingcloud.authorizationserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String name);
}
