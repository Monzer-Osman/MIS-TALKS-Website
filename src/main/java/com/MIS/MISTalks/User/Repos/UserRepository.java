package com.MIS.MISTalks.User.Repos;

import com.MIS.MISTalks.User.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository
        extends JpaRepository<User, Integer> {
      @Query(value = "SELECT * FROM users WHERE ?1 = email", nativeQuery = true)
      public Optional<User> findByEmail(String email);
}
