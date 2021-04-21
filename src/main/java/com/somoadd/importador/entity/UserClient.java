package com.somoadd.importador.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class UserClient extends AbstractBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToOne
	private User user;

	@OneToOne
	private Client client;

	private Boolean isMaster;

	public UserClient() {
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Boolean getMaster() {
		return isMaster;
	}

	public void setMaster(Boolean master) {
		isMaster = master;
	}
}
