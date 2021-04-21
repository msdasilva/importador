package com.somoadd.importador.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Users", uniqueConstraints = { @UniqueConstraint(columnNames = "Username"),
		@UniqueConstraint(columnNames = "Email") })

public class User {

	public User(long userId, String userName, String userEmail) {
		id = userId;
		username = userName;
		email = userEmail;
	}

	public User(long userId, String userName, String userEmail, Boolean Active) {
		id = userId;
		username = userName;
		email = userEmail;
		active = Active;
	}

	public User(long userId, String userName, String userEmail, Boolean Active, Boolean excluded) {
		id = userId;
		username = userName;
		email = userEmail;
		active = Active;
		this.setExcluded(excluded);
	}

	public User(long userId, String userName, String userEmail, Set<ClientUserRole> clientUsrRoles) {
		id = userId;
		username = userName;
		email = userEmail;
		clientUserRoles = clientUsrRoles;
	}

	public User(String username, String email) {

		this.username = username;
		this.email = email;

	}

	public User(Long userId, String username) {
		this.id = userId;
		this.username = username;
	}

	public User(String username, String email, String password) {

		this.username = username;
		this.email = email;
		this.password = password;
	}

	public User() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 20)
	private String username;

	@NotBlank
	@Size(max = 50)
	private String email;

	@NotBlank
	@Size(max = 120)
	private String password;

	private Boolean active;

	private Boolean excluded;

	@OneToMany(fetch = FetchType.LAZY)
	private Set<ClientUserRole> clientUserRoles;

	@Transient
	private String role;

	private LocalDateTime dataNascimento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDateTime dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Set<ClientUserRole> getClientUserRoles() {
		return clientUserRoles;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getExcluded() {
		return excluded;
	}

	public void setExcluded(Boolean excluded) {
		this.excluded = excluded;
	}
}