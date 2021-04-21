package com.somoadd.importador.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class ObservedEntity extends AbstractBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ObservedEntity() {

	}

	public ObservedEntity(EntityDs entity) {

		this.entity = entity;
	}

	public ObservedEntity(DataSet dataSet) {

		this.setDataSet(dataSet);
	}

	public ObservedEntity(long observedEntityId, long entityId, String entityName, long projectId, String projectName,
			long datasetId, String datasetName) {

		super();
		super.setId(observedEntityId);

		this.entity = new EntityDs();
		this.entity.setId(entityId);
		this.entity.setName(entityName);

		this.project = new Project();
		this.project.setId(projectId);
		this.project.setName(projectName);

		this.dataSet = new DataSet();
		this.dataSet.setId(datasetId);
		this.dataSet.setName(datasetName);
	}

	public ObservedEntity(long observedEntityId, long entityId, String name, String UF) {

		super();
		super.setId(observedEntityId);
		this.entity = new EntityDs();
		this.entity.setId(entityId);
		this.entity.setName(name);
		this.entity.setUF(UF);
	}

	public ObservedEntity(long observedEntityId, long entityId, String entityName) {
		super();
		super.setId(observedEntityId);

		this.entity = new EntityDs();
		this.entity.setId(entityId);
		this.entity.setName(entityName);

	}

	@OneToOne
	private Project project;

	@OneToOne
	private EntityDs entity;

	@OneToOne
	private DataSet dataSet;

	@ManyToMany
	private List<Hierarchy> hierarchy;

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public EntityDs getEntity() {
		return entity;
	}

	public void setEntity(EntityDs entity) {
		this.entity = entity;
	}

	public DataSet getDataSet() {
		return dataSet;
	}

	public void setDataSet(DataSet dataSet) {
		this.dataSet = dataSet;
	}

	public List<Hierarchy> getHierarchy() {
		return hierarchy;
	}

	public void setHierarchy(List<Hierarchy> hierarchy) {
		this.hierarchy = hierarchy;
	}

}
