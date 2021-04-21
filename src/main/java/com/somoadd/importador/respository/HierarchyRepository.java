package com.somoadd.importador.respository;

import java.util.List;

import com.somoadd.importador.entity.Hierarchy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface HierarchyRepository extends JpaRepository<Hierarchy,Long> {

	@Query("select new Hierarchy(h.id,h.name) from Hierarchy h join h.dataSetList d where d.id= :idDataset")
	List<Hierarchy> GetHierarchiesByDataset(@Param("idDataset") long idDataset);

	@Query("select new Hierarchy(h.id,h.name, h.hierarchy.id) from Hierarchy h where h.hierarchy.id = :hierarchyId")
	List<Hierarchy> searchByHierarchyId(@Param("hierarchyId") long hierarchyId);

	@Query(nativeQuery=true,value="select h.* FROM entity_hierarchies eh inner join hierarchy h on h.id= eh.hierarchies_id inner join entity e on eh.entity_ds_id = e.id WHERE entity_ds_id = :entityId")
	List<Hierarchy> getHierarchiesByEntity(@Param("entityId") long entityId);

	Hierarchy findTopByName(String name);

	@Transactional
	@Modifying
	@Query(nativeQuery=true,value="delete from entity_hierarchies WHERE entity_ds_id = :entityId and hierarchies_id = :idHierarchy")
	void removeByIdHierarchy(@Param("entityId") long entityId, @Param("idHierarchy") long idHierarchy);

	@Query(nativeQuery=true,value="select h.hierarchy_id from Hierarchy h where h.id = :hierarchyId")
	Long getParentFromChild(@Param("hierarchyId") long hierarchyId);

	@Query(nativeQuery =true,value= "select h.id,h.name,hierarchy_id,hierarchy_category_id,h.created_At,h.updated_At from hierarchy h inner join entity_hierarchies eh on h.id = eh.hierarchies_id inner join entity e on eh.entity_ds_id=e.id inner join entity_dataset_list edl on edl.entity_ds_id = e.id inner join data_set d on edl.dataset_list_id = d.id  where e.id = :entityId and d.id = :datasetId")
	Hierarchy getHierarchyByEntityAndDataset(@Param("datasetId") long datasetId,@Param("entityId") long entityId);
}
