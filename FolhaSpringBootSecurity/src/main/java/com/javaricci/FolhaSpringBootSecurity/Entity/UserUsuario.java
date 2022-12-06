package com.javaricci.FolhaSpringBootSecurity.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "UserUsuario")
@SequenceGenerator(name = "seq_userusuario", sequenceName = "seq_userusuario", allocationSize = 1, initialValue = 1)
public class UserUsuario {
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_userusuario")
	private Long id;

	@Column(name = "username", unique = true, nullable = false, length = 255)
	private String username;
	
	@Column(name = "password", nullable=false, length = 255)
	private String password;
	
	@Column(name = "role", nullable=false, length = 45)
	private String role;
	
	@Column(name = "enabled")
	private boolean enabled;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
