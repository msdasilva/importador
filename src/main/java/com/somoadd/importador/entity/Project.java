package com.somoadd.importador.entity;

import Enuns.ProjectTypeEnum;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Projects")
public class Project extends AbstractBaseEntity {

	private static final long serialVersionUID = 1L;

	@NotBlank
	@Size(max = 500)
	private String name;

	@NotBlank
	@Size(max = 20000)
	private String description;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ProjectTypeEnum type;

	private String projectKey;

	private Boolean active;

	private Boolean excluded;

	private Boolean running;

	@ManyToMany
	private List<DataSet> dataSetList;

	@ManyToOne
	public Client client;

	public Project() {
	}

	public Project(long projectId) {
		super();
		super.setId(projectId);
	}

	public Project(long id, String name, String description, ProjectTypeEnum type, String projectKey) {
		super();
		super.setId(id);
		this.name = name;
		this.description = description;
		this.type = type;
		this.projectKey = projectKey;
	}

	public Project(long projectId, String name, String description, ProjectTypeEnum type, Boolean active,
			LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		super.setId(projectId);
		super.setCreatedAt(createdAt);
		super.setUpdatedAt(updatedAt);
		this.name = name;
		this.description = description;
		this.type = type;
		this.active = active;
	}

	public Project(long projectId, String name, String description, ProjectTypeEnum type, Boolean active,
			LocalDateTime createdAt, LocalDateTime updatedAt, Client client) {
		super();
		super.setId(projectId);
		super.setCreatedAt(createdAt);
		super.setUpdatedAt(updatedAt);
		this.name = name;
		this.description = description;
		this.type = type;
		this.active = active;
		this.client = client;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProjectTypeEnum getType() {
		return type;
	}

	public void setType(ProjectTypeEnum type) {
		this.type = type;
	}

	public String getProjectKey() {
		return projectKey;
	}

	public void setProjectKey(String projectKey) {
		this.projectKey = projectKey;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getRunning() {
		return running;
	}

	public void setRunning(Boolean running) {
		this.running = running;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<DataSet> getDataSetList() {
		return dataSetList;
	}

	public void setDataSetList(List<DataSet> dataSetList) {
		this.dataSetList = dataSetList;
	}

	public Boolean getExcluded() {
		return excluded;
	}

	public void setExcluded(Boolean excluded) {
		this.excluded = excluded;
	}
}