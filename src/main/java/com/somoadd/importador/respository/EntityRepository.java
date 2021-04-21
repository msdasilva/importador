package com.somoadd.importador.respository;


import com.somoadd.importador.entity.EntityDs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EntityRepository extends JpaRepository<EntityDs,Long> {
	List<EntityDs> findAll();
	
	@Query(nativeQuery=true,value="Select from EntityDs where dataset_id= : datasetId")
	List<EntityDs> getEntitiesByDataSet(long datasetId);

	@Query("select new EntityDs(e.id,e.name,e.UF,e.lastCaptureDate,d.id,d.name) from EntityDs e join e.DatasetList d where d.id = :idDataSet order by e.name")
	List<EntityDs> GetAllEntitiesByDataSetId(@Param("idDataSet") long idDataSet);

	@Query("select new EntityDs(e.id,e.name,e.UF,e.lastCaptureDate,e.createdAt,e.entityType,e.email,e.urlFoto,e.siglaPartido,e.intencaoVoto)from EntityDs e where e.name like %:name%")
	List<EntityDs> getEntitiesByName(String name);

	@Query("select new EntityDs(e.id,e.name,e.UF,e.lastCaptureDate,h.id,h.name) from EntityDs e join e.hierarchies h where h.id = :hierarchyId and e.verifiedApi = true order by h.name")
	List<EntityDs> GetEntitiesByHierarchy(long hierarchyId);

	@Query("select new EntityDs(e.id,e.name,e.UF,e.lastCaptureDate,e.createdAt,e.entityType,e.email,e.urlFoto,e.siglaPartido,e.intencaoVoto)from EntityDs e where e.verifiedApi = true and e.entityType ='Deputado Federal' ")
	List<EntityDs> getDeputadosFederaisMandatoAtivo();

	@Query("select new EntityDs(e.id,e.name,e.UF,e.lastCaptureDate,e.createdAt,e.entityType,e.email,e.urlFoto,e.siglaPartido,e.intencaoVoto)from EntityDs e where e.verifiedApi = true")
	List<EntityDs> getDeputadosVerifiedApi();

	@Query("select new EntityDs(e.id,e.name,e.UF,e.lastCaptureDate,e.createdAt,e.entityType,e.email,e.urlFoto,e.siglaPartido,e.intencaoVoto)from EntityDs e where e.verifiedApi = true and e.entityType ='Deputado Federal' and e.name =:name ")
	EntityDs GetDeputadoMandatoAtivo(String name);

	@Query("select new EntityDs(e.id,e.name,e.UF,e.lastCaptureDate)from EntityDs e where e.id = :entityId")
	EntityDs getById(@Param("entityId") long entityId);

}
