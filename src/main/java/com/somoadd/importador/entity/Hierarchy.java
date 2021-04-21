package com.somoadd.importador.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Hierarchy extends AbstractBaseEntity {

	private static final long serialVersionUID = 1L;

	public Hierarchy() {
	}

	public Hierarchy(long id) {
		super();
		super.setId(id);
	}

	public Hierarchy(long id, String name) {
		super();
		super.setId(id);
		this.name = name;
	}

	public Hierarchy(long id, String name, Collection<Hierarchy> hierarchies) {
		super();
		super.setId(id);
		this.name = name;
		this.hierarchies = new ArrayList<>(hierarchies);
	}

	public Hierarchy(long id, String name, Hierarchy hierarchy) {
		super();
		super.setId(id);
		this.name = name;
		this.hierarchy = hierarchy;
	}

	public Hierarchy(long id, String name, long hierarchyId) {
		super();
		super.setId(id);
		this.name = name;
		var hierarchyObj = new Hierarchy();
		hierarchyObj.setId(hierarchyId);
		this.hierarchy = hierarchyObj;
	}

	@NotBlank
	@Size(max = 60)
	private String name;

	@ManyToOne
	private Hierarchy hierarchy;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hierarchy")
	private List<Hierarchy> hierarchies;

	@ManyToMany(fetch = FetchType.LAZY)
	private List<EntityDs> entities;

	@ManyToMany(fetch = FetchType.LAZY)
	private List<DataSet> dataSetList;

	@OneToOne
	private HierarchyCategory hierarchyCategory;

	@ManyToMany
	private List<ObservedEntity> observedEntities;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EntityDs> getEntities() {
		return entities;
	}

	public void setEntities(List<EntityDs> entities) {
		this.entities = entities;
	}

	public List<DataSet> getDataSetList() {
		return dataSetList;
	}

	public void setDataSetList(List<DataSet> dataSetList) {
		this.dataSetList = dataSetList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public HierarchyCategory getHierarchyCategory() {
		return hierarchyCategory;
	}

	public void setHierarchyCategory(HierarchyCategory hierarchyCategory) {
		this.hierarchyCategory = hierarchyCategory;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Hierarchy getHierarchy() {
		return hierarchy;
	}

	public void setHierarchy(Hierarchy hierarchy) {
		this.hierarchy = hierarchy;
	}

	public List<Hierarchy> getHierarchies() {
		return hierarchies;
	}

	public void setHierarchies(List<Hierarchy> hierarchies) {
		this.hierarchies = hierarchies;
	}

	public List<ObservedEntity> getObservedEntities() {
		return observedEntities;
	}

	public void setObservedEntities(List<ObservedEntity> observedEntities) {
		this.observedEntities = observedEntities;
	}
}
