package com.javaricci.FolhaSpringBootSecurity.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaricci.FolhaSpringBootSecurity.Entity.TabelaEncargos;
import com.javaricci.FolhaSpringBootSecurity.Repository.TabelaEncargosRepos;;

@Service
public class TabelaEncargosServiceImpl implements TabelaEncargosService {

	@Autowired
	private TabelaEncargosRepos tabEncRepos;

	@Override
	public List<TabelaEncargos> getAllEncargosList() {
		return tabEncRepos.findAll();
	}

	@Override
	public void save(TabelaEncargos tabEncargos) {
		tabEncRepos.save(tabEncargos);
	}

	@Override
	public TabelaEncargos findById(long id) {
		return tabEncRepos.findById(id).get();
	}

	@Override
	public void delete(TabelaEncargos tabEncargos) {
		tabEncRepos.delete(tabEncargos);
	}

	@Override
	public TabelaEncargos get(long id) {
		return tabEncRepos.findById(id).get();
	}

	@Override
	public void delete(long id) {
		tabEncRepos.deleteById(id);
	}

	@Override
	public List<TabelaEncargos> findByKeyword(String keyword) {
		return tabEncRepos.findByKeyword(keyword);
	}


	
	
}
