package com.somoadd.importador.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Datasource extends AbstractBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Datasource() {

	}

	public Datasource(Long id, String name) {
		super();
		super.setId(id);
		this.name = name;
	}


	public Datasource(Long id, String name, String iconStr){
		super();
		super.setId(id);
		this.name = name;
		this.iconStr = iconStr;
	}

	@NotBlank
	@Size(max = 20)
	private String name;

	private String iconStr;

	@ManyToMany
	private List<EntityDs> entityDS;

	public String getIconStr() {
		return iconStr;
	}

	public void setIconStr(String iconStr) {
		this.iconStr = iconStr;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	private List<DataSet> dataSetList;
	
//	@ManyToMany(fetch = FetchType.LAZY)
//	private List<EntityDs> entities;

	public List<DataSet> getDataSetList() {
		return dataSetList;
	}

	public void setDataSetList(List<DataSet> dataSetList) {
		this.dataSetList = dataSetList;
	}

//	public List<EntityDs> getEntities() {
//		return entities;
//	}
//
//	public void setEntities(List<EntityDs> entities) {
//		this.entities = entities;
//	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EntityDs> getEntityDS() {
		return entityDS;
	}

	public void setEntityDS(List<EntityDs> entityDS) {
		this.entityDS = entityDS;
	}
}
