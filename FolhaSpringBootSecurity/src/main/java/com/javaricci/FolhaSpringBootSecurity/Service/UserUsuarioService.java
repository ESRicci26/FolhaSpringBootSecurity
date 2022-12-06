package com.javaricci.FolhaSpringBootSecurity.Service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.javaricci.FolhaSpringBootSecurity.Entity.UserUsuario;
import com.javaricci.FolhaSpringBootSecurity.Repository.UserUsuarioRepository;

@Service
public class UserUsuarioService {

	@Autowired
	private UserUsuarioRepository userUsuarioRepos;
	
	public List<UserUsuario> listAll() {		
		return (List<UserUsuario>) userUsuarioRepos.findAll();
	}
	
	public void save(UserUsuario user) {
		userUsuarioRepos.save(user);
	}
	
	public UserUsuario get(Long id) {
		return userUsuarioRepos.findById(id).get();
	}
	
	public void delete(Long id) {
		userUsuarioRepos.deleteById(id);
	}
	
	@Transactional(readOnly = false)
	public void salvarUsuario(UserUsuario usuario) {
		String crypt = new BCryptPasswordEncoder().encode(usuario.getPassword());
		usuario.setPassword(crypt);

		userUsuarioRepos.save(usuario); 
		//System.out.println("Senha Gerado UserService "+crypt);
	}

	@Transactional(readOnly = true)
	public UserUsuario buscarPorId(Long id) {
		
		return userUsuarioRepos.findById(id).get();
	}

	
}
