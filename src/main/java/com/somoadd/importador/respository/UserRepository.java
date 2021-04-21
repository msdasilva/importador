package com.somoadd.importador.respository;

import java.util.Optional;

import com.somoadd.importador.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    @Query("Select new User(u.id,u.username,u.email,u.active, u.excluded) from User u where u.id= :userId")
    User getById(@Param("userId")long userId);

}
