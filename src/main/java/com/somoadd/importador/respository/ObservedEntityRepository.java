package com.somoadd.importador.respository;

import com.somoadd.importador.entity.DataSet;
import com.somoadd.importador.entity.EntityDs;
import com.somoadd.importador.entity.Hierarchy;
import com.somoadd.importador.entity.ObservedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ObservedEntityRepository extends JpaRepository<ObservedEntity,Long> {

    @Query("select new ObservedEntity(o.id,o.entity.id,o.entity.name,o.entity.UF) from ObservedEntity o where o.project.id = :projectId")
    List<ObservedEntity> GetObservedEntitiesByProject(@Param("projectId") long projectId);

    @Query("select new ObservedEntity(o.id,o.entity.id,o.entity.name,o.project.id,o.project.name,o.dataSet.id,o.dataSet.name) from ObservedEntity o where o.project.id = :projectId")
    List<ObservedEntity> GetObservedEntitiesByProjectId(@Param("projectId") long projectId);

    @Query("select distinct o.dataSet from ObservedEntity o join o.dataSet d on o.dataSet.id = d.id left join o.entity e left join o.hierarchy h where o.project.id = :projectId")
    List<DataSet> GetAllDataSetsByProject(@Param("projectId") long projectId);

    @Transactional
    @Modifying
    @Query("delete from ObservedEntity o where o.project.id = :projectId and o.dataSet.id = :datasetId")
    void deleteByProjectIdAndDataSetId(long projectId, long datasetId);

    @Transactional
    @Modifying
    @Query("delete from ObservedEntity o where o.project.id = :projectId and o.dataSet.id = :datasetId and o.entity.id = :entityId")
    void deleteByProjectIdAndDataSetIdAndEntityId(long projectId, long datasetId, long entityId);

    @Query("Select o from ObservedEntity o where o.project.id =:projectId and o.entity.id =:entityId and o.dataSet.id =:datasetId")
    ObservedEntity GetEntityByProjectAndDataset(long projectId, long entityId, long datasetId);

    @Query("Select distinct new DataSet (o.dataSet.id,o.dataSet.name) from ObservedEntity o join o.dataSet d on o.dataSet.id= d.id where o.project.id  =:projectId")
    List<DataSet> GetDatasetsFromProject(@Param("projectId") long projectId);

    @Query("Select new EntityDs(o.entity.id,o.entity.name,o.entity.UF,o.entity.lastCaptureDate,o.dataSet.id,o.dataSet.name) from ObservedEntity o where o.dataSet.id  =:datasetId and o.project.id =:projectId")
    List<EntityDs>GetEntitiesFromDatasetAndProject(long projectId, long datasetId);

    @Query("select new ObservedEntity (o.id,o.entity.id,o.entity.name) from ObservedEntity o where o.project.id = :projectId and o.dataSet.id = :dataSetId")
    List<ObservedEntity> GetAllEntitiesFromProjectAndDataset(@Param("projectId") long projectId, @Param("dataSetId") long dataSetId);

    @Query("select o.hierarchy from ObservedEntity o left join o.hierarchy where o.id = :observedEntityId")
    List<Hierarchy> getHierarchiesFromObservedEntity(@Param("observedEntityId") long observedEntityId);

    @Query("select distinct o.hierarchy from ObservedEntity o left join o.hierarchy left join o.project where o.id = :observedEntityId and o.project.id = :projectId")
    List<Hierarchy> getHierarchiesFromProjectObservedEntity(@Param ("observedEntityId") long observedEntityId, @Param("projectId") long projectId);

    @Query("select new Hierarchy(h.id,h.name) from ObservedEntity o join o.hierarchy h where o.project.id = :projectId and o.dataSet.id = :datasetId")
    List<Hierarchy> getHierarchiesFromDatasetProject(@Param("datasetId") long datasetId, @Param("projectId") long projectId);


}
