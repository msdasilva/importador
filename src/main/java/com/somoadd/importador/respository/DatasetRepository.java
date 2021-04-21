package com.somoadd.importador.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.somoadd.importador.entity.DataSet;
import com.somoadd.importador.entity.Datasource;

@Repository
public interface DatasetRepository extends JpaRepository<DataSet, Long> {

	@Query(value = "select new DataSet (d.id,d.name,d.publicDt) FROM DataSet d left join d.owner where d.publicDt = true or d.publicDt is null and d.excluded=false")
	List<DataSet> GetAllPublicDatasets();

	@Query("select distinct new DataSet(d.id,d.name,d.owner,d.publicDt) FROM DataSet d left join d.owner o where d.owner.id = :userId and d.excluded=false")
	List<DataSet> GetAllDataSetsFromUser(@Param("userId") long userId);

	@Query("select distinct new DataSet(d.id,d.name,d.owner,d.publicDt) FROM DataSet d left join d.owner o where d.owner.id = :clientId and d.excluded=false ")
	// @Query("select distinct d FROM DataSet d left join d.owner o where d.owner.id
	// = :clientId and d.excluded=false ")
	List<DataSet> GeAllDataSetsByClientId(@Param("clientId") long clientId);

	@Query(nativeQuery = true, value = "select d from Datasources d join Hierarchy h where h.id = :idHierarchy and d.excluded=false")
	List<Datasource> GetAllDataSourcesFromHierarchy(long idHierarchy);

	@Query("select new DataSet(d.id,d.name,d.dataSetCategory) FROM DataSet d where d.dataSetCategory.id = :idDataSetCategory and d.excluded=false")
	List<DataSet> FindAllByDataSetCategory(long idDataSetCategory);

	@Query("select new DataSet(d.id,d.name,d.dataSetCategory) FROM DataSet d join d.Entities e where e.id = :entityId")
	List<DataSet> findAllByEntityId(long entityId);

	@Query("select d,d.owner FROM DataSet d left join d.owner o where d.id = :datasetId")
	DataSet GetById(@Param("datasetId") long datasetId);

	@Query("select new DataSet (d.id,d.name) FROM DataSet d where d.id = :datasetId and d.owner.id = :clientId")
	DataSet getDatasetClient(@Param("datasetId") long datasetId, @Param("clientId") long clientId);
}
