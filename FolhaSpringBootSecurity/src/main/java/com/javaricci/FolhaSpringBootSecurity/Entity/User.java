package com.javaricci.FolhaSpringBootSecurity.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
@SequenceGenerator(name = "seq_user", sequenceName = "seq_user", allocationSize = 1, initialValue = 1)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
	private Integer id;

	@Column(name = "usuario_nome", nullable = true, length = 60)
	private String userName;

	@Column(name = "numero_celular", nullable = false, length = 16)
	private String mobileNo;

	@Column(name = "email_pessoal", nullable = false, unique = true, length = 60)
	private String emailId;

	@Column(name = "cidade", nullable = false, length = 40)
	private String city;

	@Column(name = "senha", nullable = false, length = 20)
	private String password;
	
	@Column(name = "salario_contratual", length = 16)
	private Double salario;
	
	@Column(name = "horas_base", length = 6)
	private Double horasBase;
	
	@Column(name = "salario_dia", length = 16)
	private Double salarioDia;
	
	@Column(name = "salario_hora", length = 16)
	private Double salarioHora;
	
	@Column(name = "salario_pagar", length = 16)
	private Double salarioPagar;

	@Column(name = "dias_trabalhados", length = 16)
	private Double diasTrabalahados;

	@Column(name = "horas_trabalhadas", length = 16)
	private Double horasTrabalahadas;

	@Column(name = "qtd_dep_irrf", length = 6)
	private Double qtddepirrf;

	@Column(name = "qtd_dep_salfam", length = 6)
	private Double qtddepsalfam;

	@Column(name = "qtd_horasextra001", length = 6)
	private Double qtdHorasExtra001;

	@Column(name = "valor_horasextra001", length = 16)
	private Double valorHorasExtra001;
	
	@Column(name = "qtd_horasextra002", length = 6)
	private Double qtdHorasExtra002;

	@Column(name = "valor_horasextra002", length = 16)
	private Double valorHorasExtra002;

	@Column(name = "valor_dsr", length = 16)
	private Double valorDsr;

	@Column(name = "valor_salfam", length = 16)
	private Double valorsalfam;

	@Column(name = "irrf_valor", length = 16)
	private Double irrfValor;

	@Column(name = "perc_prevprivada", length = 6)
	private Double percPrevPrivada;

	@Column(name = "valor_prevprivada", length = 16)
	private Double valorPrevPrivada;

	@Column(name = "qtd_diasfaltas", length = 6)
	private Double qtdDiasFaltas;

	@Column(name = "valor_diasfaltas", length = 16)
	private Double valorDiasFaltas;

	@Column(name = "qtd_horasatraso", length = 6)
	private Double qtdHorasAtraso;

	@Column(name = "valor_horasatraso", length = 16)
	private Double valorHorasAtraso;

	@Column(name = "valor_baseinss", length = 16)
	private Double valorBaseInss;

	@Column(name = "valor_baseirrf", length = 16)
	private Double valorBaseIrrf;

	@Column(name = "valor_basesalfam", length = 16)
	private Double valorBaseSalFam;
	
	@Column(name = "inss_valor", length = 16)
	private Double inssValor;

	@Column(name = "email_titulo", length = 255)
	private String emailtitulo;

	@Column(name = "email_mensagem", length = 255)
	private String emailmensagem;
	
	@Column(name = "cpf", length = 14)
	private String cpf;

	@Column(name = "cnpj", length = 18)
	private String cnpj;

	@Column(name = "cep", length = 8)
	private String cep;

	@Column(name = "endereco", length = 255)
	private String endereco;

	@Column(name = "numero", length = 6)
	private String numero;

	@Column(name = "complemento", length = 30)
	private String complemento;

	@Column(name = "bairro", length = 30)
	private String bairro;

	@Column(name = "estado_uf", length = 02)
	private String estado;



	public String getEmailtitulo() {
		return emailtitulo;
	}

	public void setEmailtitulo(String emailtitulo) {
		this.emailtitulo = emailtitulo;
	}

	public String getEmailmensagem() {
		return emailmensagem;
	}

	public void setEmailmensagem(String emailmensagem) {
		this.emailmensagem = emailmensagem;
	}

	public User() {

	}

	public Integer getId() {

		return id;

	}

	public void setId(Integer id) {

		this.id = id;

	}

	public String getUserName() {

		return userName;

	}

	public void setUserName(String userName) {

		this.userName = userName;

	}

	public String getMobileNo() {

		return mobileNo;

	}

	public void setMobileNo(String mobileNo) {

		this.mobileNo = mobileNo;

	}

	public String getEmailId() {

		return emailId;

	}

	public void setEmailId(String emailId) {

		this.emailId = emailId;

	}

	public String getCity() {

		return city;

	}

	public void setCity(String city) {

		this.city = city;

	}

	public String getPassword() {

		return password;

	}

	public void setPassword(String password) {

		this.password = password;

	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Double getHorasBase() {
		return horasBase;
	}

	public void setHorasBase(Double horasBase) {
		this.horasBase = horasBase;
	}

	public Double getSalarioDia() {
		return salarioDia;
	}

	public void setSalarioDia(Double salarioDia) {
		this.salarioDia = salarioDia;
	}

	public Double getSalarioHora() {
		return salarioHora;
	}

	public void setSalarioHora(Double salarioHora) {
		this.salarioHora = salarioHora;
	}

	public Double getSalarioPagar() {
		return salarioPagar;
	}

	public void setSalarioPagar(Double salarioPagar) {
		this.salarioPagar = salarioPagar;
	}

	public Double getInssValor() {
		return inssValor;
	}

	public void setInssValor(Double inssValor) {
		this.inssValor = inssValor;
	}

	public Double getDiasTrabalahados() {
		return diasTrabalahados;
	}

	public void setDiasTrabalahados(Double diasTrabalahados) {
		this.diasTrabalahados = diasTrabalahados;
	}

	public Double getHorasTrabalahadas() {
		return horasTrabalahadas;
	}

	public void setHorasTrabalahadas(Double horasTrabalahadas) {
		this.horasTrabalahadas = horasTrabalahadas;
	}

	public Double getQtddepirrf() {
		return qtddepirrf;
	}

	public void setQtddepirrf(Double qtddepirrf) {
		this.qtddepirrf = qtddepirrf;
	}

	public Double getQtddepsalfam() {
		return qtddepsalfam;
	}

	public void setQtddepsalfam(Double qtddepsalfam) {
		this.qtddepsalfam = qtddepsalfam;
	}

	public Double getQtdHorasExtra001() {
		return qtdHorasExtra001;
	}

	public void setQtdHorasExtra001(Double qtdHorasExtra001) {
		this.qtdHorasExtra001 = qtdHorasExtra001;
	}

	public Double getValorHorasExtra001() {
		return valorHorasExtra001;
	}

	public void setValorHorasExtra001(Double valorHorasExtra001) {
		this.valorHorasExtra001 = valorHorasExtra001;
	}

	public Double getQtdHorasExtra002() {
		return qtdHorasExtra002;
	}

	public void setQtdHorasExtra002(Double qtdHorasExtra002) {
		this.qtdHorasExtra002 = qtdHorasExtra002;
	}

	public Double getValorHorasExtra002() {
		return valorHorasExtra002;
	}

	public void setValorHorasExtra002(Double valorHorasExtra002) {
		this.valorHorasExtra002 = valorHorasExtra002;
	}

	public Double getValorDsr() {
		return valorDsr;
	}

	public void setValorDsr(Double valorDsr) {
		this.valorDsr = valorDsr;
	}

	public Double getValorsalfam() {
		return valorsalfam;
	}

	public void setValorsalfam(Double valorsalfam) {
		this.valorsalfam = valorsalfam;
	}

	public Double getIrrfValor() {
		return irrfValor;
	}

	public void setIrrfValor(Double irrfValor) {
		this.irrfValor = irrfValor;
	}

	public Double getPercPrevPrivada() {
		return percPrevPrivada;
	}

	public void setPercPrevPrivada(Double percPrevPrivada) {
		this.percPrevPrivada = percPrevPrivada;
	}

	public Double getValorPrevPrivada() {
		return valorPrevPrivada;
	}

	public void setValorPrevPrivada(Double valorPrevPrivada) {
		this.valorPrevPrivada = valorPrevPrivada;
	}

	public Double getQtdDiasFaltas() {
		return qtdDiasFaltas;
	}

	public void setQtdDiasFaltas(Double qtdDiasFaltas) {
		this.qtdDiasFaltas = qtdDiasFaltas;
	}

	public Double getValorDiasFaltas() {
		return valorDiasFaltas;
	}

	public void setValorDiasFaltas(Double valorDiasFaltas) {
		this.valorDiasFaltas = valorDiasFaltas;
	}

	public Double getQtdHorasAtraso() {
		return qtdHorasAtraso;
	}

	public void setQtdHorasAtraso(Double qtdHorasAtraso) {
		this.qtdHorasAtraso = qtdHorasAtraso;
	}

	public Double getValorHorasAtraso() {
		return valorHorasAtraso;
	}

	public void setValorHorasAtraso(Double valorHorasAtraso) {
		this.valorHorasAtraso = valorHorasAtraso;
	}

	public Double getValorBaseInss() {
		return valorBaseInss;
	}

	public void setValorBaseInss(Double valorBaseInss) {
		this.valorBaseInss = valorBaseInss;
	}

	public Double getValorBaseIrrf() {
		return valorBaseIrrf;
	}

	public void setValorBaseIrrf(Double valorBaseIrrf) {
		this.valorBaseIrrf = valorBaseIrrf;
	}

	public Double getValorBaseSalFam() {
		return valorBaseSalFam;
	}

	public void setValorBaseSalFam(Double valorBaseSalFam) {
		this.valorBaseSalFam = valorBaseSalFam;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
