package com.somoadd.importador.respository;

import com.somoadd.importador.entity.PhysicalPersonClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PhysicalPersonRepository extends JpaRepository<PhysicalPersonClient,Long> {

    @Query("select new PhysicalPersonClient (p.id,p.name) from PhysicalPersonClient p where p.id= :clientId")
    PhysicalPersonClient getIdAndNameFromUser(@Param("clientId") long clientId);
}
