package com.somoadd.importador.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class HierarchyCategory extends AbstractBaseEntity{


	public HierarchyCategory() {
		
	}
	
	private static final long serialVersionUID = 1L;
	
	
	@NotBlank
	@Size(max = 20)
	private String name;
	
	@OneToOne
	private Hierarchy hierarchies;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
