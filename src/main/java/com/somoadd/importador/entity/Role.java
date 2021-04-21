package com.somoadd.importador.entity;

import Enuns.ERole;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "Roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	public ERole name;

	@OneToMany(mappedBy = "role")
	private Set<ClientUserRole> clientUserRoles;

	public Role() {

	}

	public Role(Integer roleId, ERole roleName) {
		this.id= roleId;
		this.name =roleName;
	}

	public Role(Long roleId, ERole roleName) {
		this.id= roleId.intValue();
		this.name =roleName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ERole getName() {
		return name;
	}

	public void setName(ERole name) {
		this.name = name;
	}


}