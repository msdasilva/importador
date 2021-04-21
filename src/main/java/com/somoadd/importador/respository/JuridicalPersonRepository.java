package com.somoadd.importador.respository;


import com.somoadd.importador.entity.JuridicalPersonClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JuridicalPersonRepository extends JpaRepository<JuridicalPersonClient, Long> {

     @Query("select new JuridicalPersonClient (j.id,j.socialReason) from JuridicalPersonClient j where j.id= :clientId")
     JuridicalPersonClient getIdAndNameFromUser(@Param("clientId") long clientId);

}
