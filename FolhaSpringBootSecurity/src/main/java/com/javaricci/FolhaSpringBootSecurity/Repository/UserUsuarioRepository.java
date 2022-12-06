package com.javaricci.FolhaSpringBootSecurity.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.javaricci.FolhaSpringBootSecurity.Entity.UserUsuario;

public interface UserUsuarioRepository extends CrudRepository<UserUsuario, Long>  {

	
	@Query(value = "SELECT * FROM user_usuario WHERE username = :username AND enabled = 1", nativeQuery = true) //:username É A STRING DO @Param("username")
	public UserUsuario getUserByUsername(@Param("username") String username);

}
