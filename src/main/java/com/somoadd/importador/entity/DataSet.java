package com.somoadd.importador.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
public class DataSet extends AbstractBaseEntity {

    public DataSet() {
    }

    public DataSet(long dataSetId) {
        super();
        super.setId(dataSetId);
    }

    public DataSet(long dataSetId, String name) {

        super();
        super.setId(dataSetId);
        this.name = name;

    }

    public DataSet(long dataSetId, String name, Boolean isPublic) {

        super();
        super.setId(dataSetId);
        this.name = name;
        this.setPublicDt(isPublic);

    }

    public DataSet(long dataSetId, String name, Set<EntityDs> entities) {

        super();
        super.setId(dataSetId);
        this.name = name;
        this.setEntities(entities);
    }


    public DataSet(long idDataSet, String nameDataSet, Boolean isPublic, long dataSetCategoryId, String dataSetCategoryName, long ownerId) {
        super();
        super.setId(idDataSet);
        this.name = nameDataSet;
        this.setPublicDt(isPublic);
        this.dataSetCategory = new DataSetCategory();
        this.dataSetCategory.setId(dataSetCategoryId);
        this.dataSetCategory.setName(dataSetCategoryName);
        this.owner.setId(ownerId);
    }

    public DataSet(long id, String name, DataSetCategory dataSetCategory) {
        super();
        super.setId(id);
        this.name = name;
        this.dataSetCategory = dataSetCategory;
    }

    public DataSet(long id, String name, long ownerId, boolean publicDt) {
        super();
        super.setId(id);
        this.name = name;
        this.owner.setId(ownerId);
        this.publicDt = publicDt;
    }

    public DataSet(long id, String name, Client owner, boolean publicDt) {

        super();
        super.setId(id);
        this.name = name;

        if (!Objects.isNull(owner)) {
            this.owner = owner;
        }

        this.publicDt = publicDt;
    }

    public DataSet(long id, String name, Client owner, boolean publicDt, Set<Datasource> DataSources, Set<Hierarchy> hierarchies, Set<EntityDs> entities, Set<Project> projects) {

        super();
        super.setId(id);
        this.name = name;

        if (!Objects.isNull(owner)) {
            this.owner = owner;
        }

        this.publicDt = publicDt;
        this.setDataSources(DataSources);
        this.setHierarchy(hierarchies);
        this.setEntities(entities);
        this.setProjects(projects);
    }

    private static final long serialVersionUID = 1L;

    @NotBlank
    @Size(max = 60)
    private String name;

    private Boolean publicDt;

    @OneToOne
    private Client owner;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Hierarchy> Hierarchy;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("DatasetList")
    private Set<EntityDs> Entities;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Datasource> DataSources;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Project> Projects;

    @OneToOne(fetch = FetchType.LAZY)
    private DataSetCategory dataSetCategory;

    private Boolean excluded;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Hierarchy> getHierarchy() {
        return this.Hierarchy;
    }

    public void setHierarchy(Set<Hierarchy> hierarchy) { this.Hierarchy = hierarchy; }

    public Set<EntityDs> getEntities() {
        return this.Entities;
    }

    public void setEntities(Set<EntityDs> entities) {
        this.Entities = entities;
    }

    public Set<Datasource> getDataSources() {
        return this.DataSources;
    }

    public void setDataSources(Set<Datasource> DataSources) {
        this.DataSources = DataSources;
    }

    public Set<Project> getProjects() {
        return this.Projects;
    }

    public void setProjects(Set<Project> projects) {
        this.Projects = projects;
    }

    public DataSetCategory getDataSetCategory() {
        return this.dataSetCategory;
    }

    public void setDataSetCategory(DataSetCategory dataSetCategory) {
        this.dataSetCategory = dataSetCategory;
    }

    public Boolean getPublicDt() {
        return this.publicDt;
    }

    public void setPublicDt(Boolean publicDt) {
        this.publicDt = publicDt;
    }

    public Client getOwner() { return this.owner; }

    public void setOwner(Client owner) { this.owner = owner; }

    public Boolean getExcluded() {
        return this.excluded;
    }

    public void setExcluded(Boolean excluded) {
        this.excluded = excluded;
    }
}
