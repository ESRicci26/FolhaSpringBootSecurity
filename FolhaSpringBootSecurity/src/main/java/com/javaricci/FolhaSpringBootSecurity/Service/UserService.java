package com.javaricci.FolhaSpringBootSecurity.Service;

import java.util.List;

import com.javaricci.FolhaSpringBootSecurity.Entity.User;

public interface UserService {


	public List<User> getAllUsersList();

	public void save(User user);

	public User findById(Integer id);

	public void delete(User user);
	
	//EDILSON INSERIU
	public User get(Integer id);
	public void delete(Integer id);
	
	//Usar para exportar dados excel
	public void addStudent(User user);
    List <User> getTheListStudent();

}