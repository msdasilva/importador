package com.somoadd.importador.entity;

import Enuns.ERole;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class ClientUserRole {

	@EmbeddedId
	ClientUserRoleAssociation id;

	@ManyToOne
	@MapsId("clientId")
	@JoinColumn(name = "client_id")
	private Client client;

	@ManyToOne
	@MapsId("userId")
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@MapsId("roleId")
	@JoinColumn(name = "role_id")
	private Role role;

	public ClientUserRole() {
	}

	public ClientUserRole(Client client, Role role) {
		this.client = client;
		this.role = role;
	}

	public ClientUserRole(Client client, User user) {
		this.client = client;
		this.user = user;
	}

	public ClientUserRole(Client client) {
		this.client = client;
	}

	public ClientUserRole(User user) {
		this.user = user;
	}

	public ClientUserRole(Long id, String username, String email, Boolean active, int roleId, ERole roleName,
			Client client) {

		this.role = new Role(roleId, roleName);
		this.user = new User(id, username, email, active);

		if (client.getClass().getName().equals("br.com.SocialQi.MonitoramentoAPI.Entities.JuridicalPersonClient")) {
			this.client = new JuridicalPersonClient(client.getId());
		} else {
			this.client = new PhysicalPersonClient(client.getId());
		}

	}

	public ClientUserRoleAssociation getId() {
		return id;
	}

	public void setId(ClientUserRoleAssociation id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		ClientUserRole that = (ClientUserRole) o;
		return Objects.equals(id, that.id) && Objects.equals(client, that.client) && Objects.equals(user, that.user)
				&& Objects.equals(role, that.role);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, client, user, role);
	}
}
