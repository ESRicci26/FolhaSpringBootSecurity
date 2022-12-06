package com.javaricci.FolhaSpringBootSecurity.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.javaricci.FolhaSpringBootSecurity.Entity.TabelaEncargos;

public interface TabelaEncargosRepos extends JpaRepository<TabelaEncargos, Long> {

	// Essa QUERY filtra na TABELA "tabela_encargos" a tabela ATIVA e o nome da
	// tabela = INSS
	@Query(value = "SELECT * FROM tabela_encargos WHERE situacao=true AND nome_tabela='INSS'", nativeQuery = true)
	TabelaEncargos findInssById(Integer idInss);

	// Essa QUERY filtra na TABELA "tabela_encargos" a tabela ATIVA e o nome da
	// tabela = IRRF
	@Query(value = "SELECT * FROM tabela_encargos WHERE situacao=true AND nome_tabela='IRRF'", nativeQuery = true)
	TabelaEncargos findIrrfById(Integer idIrrf);

	// Essa QUERY filtra na TABELA "tabela_encargos" a tabela ATIVA e o nome da
	// tabela = SALFAM
	@Query(value = "SELECT * FROM tabela_encargos WHERE situacao=true AND nome_tabela='SALFAM'", nativeQuery = true)
	TabelaEncargos findSalfamiliaById(Integer idSalFam);

	// Essa QUERY filtra na TABELA "tabela_encargos" a tabela ATIVA e o nome da
	// tabela = INDICES Utilizado para índices de horas extra, índices encargos, impostos, etc..
	@Query(value = "SELECT * FROM tabela_encargos WHERE situacao=true AND nome_tabela='INDICES'", nativeQuery = true)
	TabelaEncargos findIndicesGeraisById(Integer idIndices);
	
	//@Query(value = "SELECT * FROM tabela_encargos s WHERE s.nome_tabela LIKE %:keyword% or s.valor_faixa001 LIKE %:keyword%", nativeQuery = true)
	@Query(value = "SELECT * FROM tabela_encargos tbe WHERE tbe.nome_tabela LIKE %:keyword%", nativeQuery = true)
	 List<TabelaEncargos> findByKeyword(@Param("keyword") String keyword);



}
