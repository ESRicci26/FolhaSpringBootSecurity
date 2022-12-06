package com.javaricci.FolhaSpringBootSecurity.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seq_encargos", sequenceName = "seq_encargos", allocationSize = 1, initialValue = 1)
public class TabelaEncargos {

	public TabelaEncargos() {

	}

	protected TabelaEncargos(Long id, Boolean situacao, String nomeTabela, String dataInicio, String dataFim,
			Double valorfaixa001, Double valorfaixa002, Double valorfaixa003, Double valorfaixa004,
			Double valorfaixa005, Double valorfaixa006, Double valorfaixa007, Double valorfaixa008,
			Double valorfaixa009, Double valorfaixa010, Double valorfaixa011, Double valorfaixa012,
			Double valorfaixa013, Double valorfaixa014, Double valorfaixa015, Double valorfaixa016,
			Double valorfaixa017, Double valorfaixa018, Double valorfaixa019, Double valorfaixa020,
			Double valorfaixa021, Double valorfaixa022, Double valorfaixa023, Double valorfaixa024,
			Double valorfaixa025, Double valorfaixa026, Double valorfaixa027, Double valorfaixa028,
			Double valorfaixa029, Double valorfaixa030) {
		this.id = id;
		this.situacao = situacao;
		this.nomeTabela = nomeTabela;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.valorfaixa001 = valorfaixa001;
		this.valorfaixa002 = valorfaixa002;
		this.valorfaixa003 = valorfaixa003;
		this.valorfaixa004 = valorfaixa004;
		this.valorfaixa005 = valorfaixa005;
		this.valorfaixa006 = valorfaixa006;
		this.valorfaixa007 = valorfaixa007;
		this.valorfaixa008 = valorfaixa008;
		this.valorfaixa009 = valorfaixa009;
		this.valorfaixa010 = valorfaixa010;
		this.valorfaixa011 = valorfaixa011;
		this.valorfaixa012 = valorfaixa012;
		this.valorfaixa013 = valorfaixa013;
		this.valorfaixa014 = valorfaixa014;
		this.valorfaixa015 = valorfaixa015;
		this.valorfaixa016 = valorfaixa016;
		this.valorfaixa017 = valorfaixa017;
		this.valorfaixa018 = valorfaixa018;
		this.valorfaixa019 = valorfaixa019;
		this.valorfaixa020 = valorfaixa020;
		this.valorfaixa021 = valorfaixa021;
		this.valorfaixa022 = valorfaixa022;
		this.valorfaixa023 = valorfaixa023;
		this.valorfaixa024 = valorfaixa024;
		this.valorfaixa025 = valorfaixa025;
		this.valorfaixa026 = valorfaixa026;
		this.valorfaixa027 = valorfaixa027;
		this.valorfaixa028 = valorfaixa028;
		this.valorfaixa029 = valorfaixa029;
		this.valorfaixa030 = valorfaixa030;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_encargos")
	private Long id;

	@Column(name = "situacao", length = 1)
	private Boolean situacao = false;

	@Column(name = "nome_tabela", nullable = false, length = 10)
	private String nomeTabela;

	@Column(name = "data_inicio", nullable = false, length = 10)
	private String dataInicio;

	@Column(name = "data_fim", nullable = false, length = 10)
	private String dataFim;

	@Column(name = "valor_faixa001", length = 12)
	private Double valorfaixa001;

	@Column(name = "valor_faixa002", length = 12)
	private Double valorfaixa002;

	@Column(name = "valor_faixa003", length = 12)
	private Double valorfaixa003;

	@Column(name = "valor_faixa004", length = 12)
	private Double valorfaixa004;

	@Column(name = "valor_faixa005", length = 12)
	private Double valorfaixa005;

	@Column(name = "valor_faixa006", length = 12)
	private Double valorfaixa006;

	@Column(name = "valor_faixa007", length = 12)
	private Double valorfaixa007;

	@Column(name = "valor_faixa008", length = 12)
	private Double valorfaixa008;

	@Column(name = "valor_faixa009", length = 12)
	private Double valorfaixa009;

	@Column(name = "valor_faixa010", length = 12)
	private Double valorfaixa010;

	@Column(name = "valor_faixa011", length = 12)
	private Double valorfaixa011;

	@Column(name = "valor_faixa012", length = 12)
	private Double valorfaixa012;

	@Column(name = "valor_faixa013", length = 12)
	private Double valorfaixa013;

	@Column(name = "valor_faixa014", length = 12)
	private Double valorfaixa014;

	@Column(name = "valor_faixa015", length = 12)
	private Double valorfaixa015;

	@Column(name = "valor_faixa016", length = 12)
	private Double valorfaixa016;

	@Column(name = "valor_faixa017", length = 12)
	private Double valorfaixa017;

	@Column(name = "valor_faixa018", length = 12)
	private Double valorfaixa018;

	@Column(name = "valor_faixa019", length = 12)
	private Double valorfaixa019;

	@Column(name = "valor_faixa020", length = 12)
	private Double valorfaixa020;

	// FAIXAS 01 A 15 SERÁ USADO PARA VALORES E FAIXAS 16 A 30 SERÁ USADO PARA
	// PERCENTAGEM (%)
	@Column(name = "valor_faixa021", length = 12)
	private Double valorfaixa021;

	@Column(name = "valor_faixa022", length = 12)
	private Double valorfaixa022;

	@Column(name = "valor_faixa023", length = 12)
	private Double valorfaixa023;

	@Column(name = "valor_faixa024", length = 12)
	private Double valorfaixa024;

	@Column(name = "valor_faixa025", length = 12)
	private Double valorfaixa025;

	@Column(name = "valor_faixa026", length = 12)
	private Double valorfaixa026;

	@Column(name = "valor_faixa027", length = 12)
	private Double valorfaixa027;

	@Column(name = "valor_faixa028", length = 12)
	private Double valorfaixa028;

	@Column(name = "valor_faixa029", length = 12)
	private Double valorfaixa029;

	@Column(name = "valor_faixa030", length = 12)
	private Double valorfaixa030;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getSituacao() {
		return situacao;
	}

	public void setSituacao(Boolean situacao) {
		this.situacao = situacao;
	}

	public String getNomeTabela() {
		return nomeTabela;
	}

	public void setNomeTabela(String nomeTabela) {
		this.nomeTabela = nomeTabela;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

	public Double getValorfaixa001() {
		return valorfaixa001;
	}

	public void setValorfaixa001(Double valorfaixa001) {
		this.valorfaixa001 = valorfaixa001;
	}

	public Double getValorfaixa002() {
		return valorfaixa002;
	}

	public void setValorfaixa002(Double valorfaixa002) {
		this.valorfaixa002 = valorfaixa002;
	}

	public Double getValorfaixa003() {
		return valorfaixa003;
	}

	public void setValorfaixa003(Double valorfaixa003) {
		this.valorfaixa003 = valorfaixa003;
	}

	public Double getValorfaixa004() {
		return valorfaixa004;
	}

	public void setValorfaixa004(Double valorfaixa004) {
		this.valorfaixa004 = valorfaixa004;
	}

	public Double getValorfaixa005() {
		return valorfaixa005;
	}

	public void setValorfaixa005(Double valorfaixa005) {
		this.valorfaixa005 = valorfaixa005;
	}

	public Double getValorfaixa006() {
		return valorfaixa006;
	}

	public void setValorfaixa006(Double valorfaixa006) {
		this.valorfaixa006 = valorfaixa006;
	}

	public Double getValorfaixa007() {
		return valorfaixa007;
	}

	public void setValorfaixa007(Double valorfaixa007) {
		this.valorfaixa007 = valorfaixa007;
	}

	public Double getValorfaixa008() {
		return valorfaixa008;
	}

	public void setValorfaixa008(Double valorfaixa008) {
		this.valorfaixa008 = valorfaixa008;
	}

	public Double getValorfaixa009() {
		return valorfaixa009;
	}

	public void setValorfaixa009(Double valorfaixa009) {
		this.valorfaixa009 = valorfaixa009;
	}

	public Double getValorfaixa010() {
		return valorfaixa010;
	}

	public void setValorfaixa010(Double valorfaixa010) {
		this.valorfaixa010 = valorfaixa010;
	}

	public Double getValorfaixa011() {
		return valorfaixa011;
	}

	public void setValorfaixa011(Double valorfaixa011) {
		this.valorfaixa011 = valorfaixa011;
	}

	public Double getValorfaixa012() {
		return valorfaixa012;
	}

	public void setValorfaixa012(Double valorfaixa012) {
		this.valorfaixa012 = valorfaixa012;
	}

	public Double getValorfaixa013() {
		return valorfaixa013;
	}

	public void setValorfaixa013(Double valorfaixa013) {
		this.valorfaixa013 = valorfaixa013;
	}

	public Double getValorfaixa014() {
		return valorfaixa014;
	}

	public void setValorfaixa014(Double valorfaixa014) {
		this.valorfaixa014 = valorfaixa014;
	}

	public Double getValorfaixa015() {
		return valorfaixa015;
	}

	public void setValorfaixa015(Double valorfaixa015) {
		this.valorfaixa015 = valorfaixa015;
	}

	public Double getValorfaixa016() {
		return valorfaixa016;
	}

	public void setValorfaixa016(Double valorfaixa016) {
		this.valorfaixa016 = valorfaixa016;
	}

	public Double getValorfaixa017() {
		return valorfaixa017;
	}

	public void setValorfaixa017(Double valorfaixa017) {
		this.valorfaixa017 = valorfaixa017;
	}

	public Double getValorfaixa018() {
		return valorfaixa018;
	}

	public void setValorfaixa018(Double valorfaixa018) {
		this.valorfaixa018 = valorfaixa018;
	}

	public Double getValorfaixa019() {
		return valorfaixa019;
	}

	public void setValorfaixa019(Double valorfaixa019) {
		this.valorfaixa019 = valorfaixa019;
	}

	public Double getValorfaixa020() {
		return valorfaixa020;
	}

	public void setValorfaixa020(Double valorfaixa020) {
		this.valorfaixa020 = valorfaixa020;
	}

	public Double getValorfaixa021() {
		return valorfaixa021;
	}

	public void setValorfaixa021(Double valorfaixa021) {
		this.valorfaixa021 = valorfaixa021;
	}

	public Double getValorfaixa022() {
		return valorfaixa022;
	}

	public void setValorfaixa022(Double valorfaixa022) {
		this.valorfaixa022 = valorfaixa022;
	}

	public Double getValorfaixa023() {
		return valorfaixa023;
	}

	public void setValorfaixa023(Double valorfaixa023) {
		this.valorfaixa023 = valorfaixa023;
	}

	public Double getValorfaixa024() {
		return valorfaixa024;
	}

	public void setValorfaixa024(Double valorfaixa024) {
		this.valorfaixa024 = valorfaixa024;
	}

	public Double getValorfaixa025() {
		return valorfaixa025;
	}

	public void setValorfaixa025(Double valorfaixa025) {
		this.valorfaixa025 = valorfaixa025;
	}

	public Double getValorfaixa026() {
		return valorfaixa026;
	}

	public void setValorfaixa026(Double valorfaixa026) {
		this.valorfaixa026 = valorfaixa026;
	}

	public Double getValorfaixa027() {
		return valorfaixa027;
	}

	public void setValorfaixa027(Double valorfaixa027) {
		this.valorfaixa027 = valorfaixa027;
	}

	public Double getValorfaixa028() {
		return valorfaixa028;
	}

	public void setValorfaixa028(Double valorfaixa028) {
		this.valorfaixa028 = valorfaixa028;
	}

	public Double getValorfaixa029() {
		return valorfaixa029;
	}

	public void setValorfaixa029(Double valorfaixa029) {
		this.valorfaixa029 = valorfaixa029;
	}

	public Double getValorfaixa030() {
		return valorfaixa030;
	}

	public void setValorfaixa030(Double valorfaixa030) {
		this.valorfaixa030 = valorfaixa030;
	}

}
