package com.somoadd.importador.respository;

import com.somoadd.importador.entity.UserClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserClientRepository extends JpaRepository<UserClient,Long> {
}
