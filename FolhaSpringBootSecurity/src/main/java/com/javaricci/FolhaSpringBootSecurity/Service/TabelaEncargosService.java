package com.javaricci.FolhaSpringBootSecurity.Service;

import java.util.List;

import com.javaricci.FolhaSpringBootSecurity.Entity.TabelaEncargos;

public interface TabelaEncargosService {
	
	public List<TabelaEncargos> getAllEncargosList();

	public void save(TabelaEncargos tabEncargos);

	public TabelaEncargos findById(long id);

	public void delete(TabelaEncargos tabEncargos);
	
	//EDILSON INSERIU
	public TabelaEncargos get(long id);
	public void delete(long id);
	
	public List<TabelaEncargos> findByKeyword(String keyword);
	
}
