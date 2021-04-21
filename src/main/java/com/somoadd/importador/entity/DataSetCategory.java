package com.somoadd.importador.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "DataSetCategory")
public class DataSetCategory extends AbstractBaseEntity {

	public DataSetCategory() {

	}

	private static final long serialVersionUID = 1L;
	@NotBlank
	@Size(max = 20)
	private String name;

	@OneToMany(fetch = FetchType.LAZY)
	private List<DataSet> dataSetList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

}
