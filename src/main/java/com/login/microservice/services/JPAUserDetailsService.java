package com.login.microservice.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.login.microservice.dao.IUsuarioDao;
import com.login.microservice.models.Role;
import com.login.microservice.models.Usuario;


@Service("jpaUserDetailService")
public class JPAUserDetailsService implements UserDetailsService{
	
	@Autowired
	private IUsuarioDao usuarioDao;
	
	private Logger logger = LoggerFactory.getLogger(JPAUserDetailsService.class);

//	UserDetails es una interfaz que representa un usuario autenticado.
//	Hay que decorar con Transactional ya que realiza una operación con la base de datos.
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario user = usuarioDao.findByUsername(username);
		
		if(user == null) {
			logger.error("Error login: No existe el usuario en la base de datos");
			throw new UsernameNotFoundException("Username" + username + "no existe en base de datos");	
		}
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for(Role roles: user.getRoles()) {
			logger.info("Rol ".concat(roles.getAuthority()));
			authorities.add(new SimpleGrantedAuthority(roles.getAuthority()));
		}
		
//		Se usa el isEmpty ya que es un List.-
		
		if(authorities.isEmpty()) {
			logger.error("Error login: El usuario no está autorizado");
			throw new UsernameNotFoundException("Username" + username + "no tiene permisos");	
		}
	
		return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
	}

}
