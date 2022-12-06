package com.javaricci.FolhaSpringBootSecurity.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.javaricci.FolhaSpringBootSecurity.Entity.UserUsuario;
import com.javaricci.FolhaSpringBootSecurity.Repository.UserUsuarioRepository;
import com.javaricci.FolhaSpringBootSecurity.Security.MyUserDetails;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserUsuarioRepository userusuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserUsuario user = userusuarioRepository.getUserByUsername(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("Could not find user");
		}
		
		return new MyUserDetails(user);
	}

}
