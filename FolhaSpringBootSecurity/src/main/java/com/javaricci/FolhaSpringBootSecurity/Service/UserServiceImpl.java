package com.javaricci.FolhaSpringBootSecurity.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaricci.FolhaSpringBootSecurity.Entity.User;
import com.javaricci.FolhaSpringBootSecurity.Repository.UserRepos;;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepos userRepo;
	
	@Override
	public List<User> getAllUsersList() {

		return userRepo.findAll();

	}

	@Override
	public void save(User user) {

		userRepo.save(user);

	}

	@Override
	public User findById(Integer id) {

		return userRepo.findById(id).get();

	}

	@Override
	public void delete(User user) {

		userRepo.delete(user);

	}

	
	//EDILSON INSERIU
	@Override
	public User get(Integer id) {
		return userRepo.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		userRepo.deleteById(id);
		
	}

	// Esses dois métodos é usado para gerar relatórios Excel, PDF e CSV
	@Override
	public void addStudent(User user) {
		userRepo.save(user);
		
	}

	@Override
	public List<User> getTheListStudent() {
		return userRepo.findAll();
	}
	

	/*
	@Override
	public User calcularInss(Integer id) {
		TabelaEncargos tab1 = tabelaEncRepos.getById(1L);
		Double fx01Inss = tab1.getTabfaixa001inssate();
		Double fx02Inss = tab1.getTabfaixa002inssde();
		Double tetoInss = tab1.getTabtetoinss();
		System.out.println("Faixa 001:  "+fx01Inss+"  Faixa 002:  "+fx02Inss+"  Teto INSS:  "+tetoInss);
		return userRepo.getById(id);
	}
*/
	

}