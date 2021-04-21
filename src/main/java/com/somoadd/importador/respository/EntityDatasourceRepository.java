package com.somoadd.importador.respository;


import com.somoadd.importador.entity.EntityDatasource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityDatasourceRepository extends JpaRepository<EntityDatasource,Long> {
}
