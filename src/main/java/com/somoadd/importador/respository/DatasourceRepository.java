package com.somoadd.importador.respository;


import com.somoadd.importador.entity.Datasource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DatasourceRepository extends JpaRepository<Datasource,Long> {

    @Query(nativeQuery = true,value = "select * from datasource ds inner join data_set_data_sources dd on ds.id = dd.data_sources_id inner join data_set d on d.id = dd.data_set_id where dd.data_set_id = :dataSetId")
    List<Datasource> GetAllDataSourcesByDataSet(@Param("dataSetId") long dataSetId);
}
