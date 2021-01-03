//package com.login.microservice.models;
//
//import java.io.Serializable;
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "users")
//public class Usuario implements Serializable{
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	
//	@Column(name = "username",unique = true, length = 30)
//	private String userName;
//	
//	@Column(name = "password", length = 60)
//	private String password;
//	
//	@Column(name = "enabled")
//	private boolean enabled;
//	
//	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
////	Esta columna se genera automáticamente en la tabla roles. No hay que crear el campo en esta última.-
////	Se crea en automático una tabla intermedia en la cual consta el id del usuario y el id del rol.-
//	@JoinColumn(name = "user_id")
//	private List<Role> roles;
//	
//	public String getUserName() {
//		return userName;
//	}
//	public void setUserName(String username) {
//		this.userName = username;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public boolean isEnabled() {
//		return enabled;
//	}
//	public void setEnabled(boolean enable) {
//		this.enabled = enable;
//	}
//	public List<Role> getRoles() {
//		return roles;
//	}
//	public void setRoles(List<Role> roles) {
//		this.roles = roles;
//	}
//
//
//
//	private static final long serialVersionUID = 1L;
//
//}
