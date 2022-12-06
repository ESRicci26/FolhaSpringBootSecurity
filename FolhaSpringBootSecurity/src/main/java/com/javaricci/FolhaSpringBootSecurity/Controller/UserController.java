package com.javaricci.FolhaSpringBootSecurity.Controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.javaricci.FolhaSpringBootSecurity.DTO.UserDTO;
import com.javaricci.FolhaSpringBootSecurity.Entity.TabelaEncargos;
import com.javaricci.FolhaSpringBootSecurity.Entity.User;
import com.javaricci.FolhaSpringBootSecurity.Repository.TabelaEncargosRepos;
import com.javaricci.FolhaSpringBootSecurity.Service.UserService;
import com.lowagie.text.DocumentException;

//@RestController
@Controller
@RequestMapping("/api")
public class UserController {

	//Usado no método para gerar Relatórios Excel e PDF
	Date date = new Date();
	
	//Usado para enviar e-mail
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private CsvFileGenerator csvGenerator;
	
	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private TabelaEncargosRepos tabelaEncRepos;

	// ####CRIAÇÃO DA API####

	// GET Type: http://localhost:8080/api/users
	@GetMapping("/users")
	public ResponseEntity<?> getUser() {

		Map<String, Object> jsonResponseMap = new LinkedHashMap<String, Object>();
		List<User> listofUser = userService.getAllUsersList();
		List<UserDTO> listofUserDto = new ArrayList<UserDTO>();

		if (!listofUser.isEmpty()) {

			for (User user : listofUser) {
				listofUserDto.add(modelMapper.map(user, UserDTO.class));
			}

			jsonResponseMap.put("status", 1);
			jsonResponseMap.put("data", listofUserDto);
			return new ResponseEntity<>(jsonResponseMap, HttpStatus.OK);

		} else {

			jsonResponseMap.clear();
			jsonResponseMap.put("status", 0);
			jsonResponseMap.put("message", "Os dados não foram encontrados");
			return new ResponseEntity<>(jsonResponseMap, HttpStatus.NOT_FOUND);

		}

	}

	/*
	 * POST Type: http://localhost:8080/api/save { "userName": "Edilson",
	 * "mobileNo": "32656665", "emailId": "esricci@gmail.com", "city":
	 * "São Paulo/SP", "password": "123456" }
	 */
	@PostMapping("/save")
	public ResponseEntity<?> saveUser(@RequestBody UserDTO userDto) {

		Map<String, Object> jsonResponseMap = new LinkedHashMap<String, Object>();
		// Converter DTO numa Entidade
		User user = modelMapper.map(userDto, User.class);
		userService.save(user);
		jsonResponseMap.put("status", 1);
		jsonResponseMap.put("message", "O registro foi salvo com sucesso!");
		return new ResponseEntity<>(jsonResponseMap, HttpStatus.CREATED);
	}

	// GET Type: http://localhost:8080/api/user/1
	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUserById(@PathVariable Integer id) {
		Map<String, Object> jsonResponseMap = new LinkedHashMap<String, Object>();
		try {

			User user = userService.findById(id);
			// Converter Entity em DTO
			UserDTO userDto = modelMapper.map(user, UserDTO.class);
			jsonResponseMap.put("status", 1);
			jsonResponseMap.put("data", userDto);
			return new ResponseEntity<>(jsonResponseMap, HttpStatus.OK);

		} catch (Exception ex) {

			jsonResponseMap.clear();
			jsonResponseMap.put("status", 0);
			jsonResponseMap.put("message", "Os dados não foram encontrados");
			return new ResponseEntity<>(jsonResponseMap, HttpStatus.NOT_FOUND);

		}

	}

	// DELETE Type: http://localhost:8080/api/delete/1
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
		Map<String, Object> jsonResponseMap = new LinkedHashMap<String, Object>();
		try {
			User user = userService.findById(id);
			userService.delete(user);
			jsonResponseMap.put("status", 1);
			jsonResponseMap.put("message", "O registro foi Excluído com Sucesso!");
			return new ResponseEntity<>(jsonResponseMap, HttpStatus.OK);

		} catch (Exception ex) {

			jsonResponseMap.clear();
			jsonResponseMap.put("status", 0);
			jsonResponseMap.put("message", "Os dados não foram encontrados");
			return new ResponseEntity<>(jsonResponseMap, HttpStatus.NOT_FOUND);

		}

	}

	/*
	 * PUT Type: http://localhost:8080/api/update/1 { "userName": "Salvador",
	 * "mobileNo": "30184611", "emailId": "esricci26@gmail.com", "city":
	 * "Paraná/PR", "password": "789" }
	 */
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody UserDTO userDto) {
		Map<String, Object> jsonResponseMap = new LinkedHashMap<String, Object>();
		try {

			User user = userService.findById(id);
			user.setUserName(userDto.getUserName());
			user.setMobileNo(userDto.getMobileNo());
			user.setEmailId(userDto.getEmailId());
			user.setCity(userDto.getCity());
			user.setPassword(userDto.getPassword());
			user.setSalario(userDto.getSalario());
			user.setHorasBase(userDto.getHorasBase());
			user.setSalarioDia(userDto.getSalarioDia());
			user.setSalarioHora(userDto.getSalarioHora());
			user.setSalarioPagar(userDto.getSalarioPagar());
			user.setInssValor(userDto.getInssValor());
			user.setDiasTrabalahados(userDto.getDiasTrabalahados());
			user.setHorasTrabalahadas(userDto.getHorasTrabalahadas());
			user.setQtddepirrf(userDto.getQtddepirrf());
			user.setQtddepsalfam(userDto.getQtddepsalfam());
			user.setQtdHorasExtra001(userDto.getQtdHorasExtra001());
			user.setValorHorasExtra001(userDto.getValorHorasExtra001());
			user.setQtdHorasExtra002(userDto.getQtdHorasExtra002());
			user.setValorHorasExtra002(userDto.getValorHorasExtra002());
			user.setValorDsr(userDto.getValorDsr());
			user.setValorsalfam(userDto.getValorsalfam());
			user.setIrrfValor(userDto.getIrrfValor());
			user.setPercPrevPrivada(userDto.getPercPrevPrivada());
			user.setValorPrevPrivada(userDto.getValorPrevPrivada());
			user.setQtdDiasFaltas(userDto.getQtdDiasFaltas());
			user.setValorDiasFaltas(userDto.getValorDiasFaltas());
			user.setQtdHorasAtraso(userDto.getQtdHorasAtraso());
			user.setValorHorasAtraso(userDto.getValorHorasAtraso());
			user.setValorBaseInss(userDto.getValorBaseInss());
			user.setValorBaseIrrf(userDto.getValorBaseIrrf());
			user.setValorBaseSalFam(userDto.getValorBaseSalFam());

			userService.save(user);

			jsonResponseMap.put("status", 1);
			jsonResponseMap.put("data", userService.findById(id));
			return new ResponseEntity<>(jsonResponseMap, HttpStatus.OK);

		} catch (Exception ex) {

			jsonResponseMap.clear();
			jsonResponseMap.put("status", 0);
			jsonResponseMap.put("message", "Os dados não foram encontrados");
			return new ResponseEntity<>(jsonResponseMap, HttpStatus.NOT_FOUND);

		}

	}

	// ####CRIAÇÃO DO FRONT-END USANDO THYMELEAF####
	// http://localhost:8080/api/contatos

	// Lista todos Contatos Banco de Dados na página principal index.html
	@GetMapping("/contatos")
	public String viewHomePage(Model model) {
		List<User> listPessoas = userService.getAllUsersList();
		model.addAttribute("listPessoasHtml", listPessoas);

		return "principalindex.html";
	}

	// Tela Inclusão de novo contato no Banco de Dados - Página novo_contato.html
	@GetMapping("/inclusaocontratado")
	public String showNewContatoPage(Model model) {
		User contato = new User();
		model.addAttribute("incluirContatoHtml", contato);

		return "novo_contato";
	}

	// Método para Salvar/Alterar contato no Banco de Dados
	@RequestMapping(value = "/savefront", method = RequestMethod.POST)
	public String salvarContato(@ModelAttribute("pessoa") User userContato) {
		userService.save(userContato);

		return "redirect:/api/contatos";

	}

	// Método para ALTERAR contato no Banco de Dados
	@GetMapping("/edit/{id}")
	public ModelAndView showAlterarContatoPage(@PathVariable(name = "id") Integer id) {
		ModelAndView mav = new ModelAndView("alterar_contato.html");
		User pessoaAlterar = userService.get(id);
		mav.addObject("pessoaHtml", pessoaAlterar);

		return mav;
	}

	// Método para CALCULAR Encargos no Banco de Dados
	@GetMapping("/calcinss/{id}")
	public ModelAndView showCalcularInssPage(@PathVariable(name = "id") Integer id) {
		ModelAndView mav = new ModelAndView("alterar_contato.html");
		User pessoaAlterar = userService.get(id);
		mav.addObject("pessoaHtml", pessoaAlterar);

		TabelaEncargos tabInss = tabelaEncRepos.findInssById(id);
		Double inssFx01 = tabInss.getValorfaixa001();
		Double inssFx02 = tabInss.getValorfaixa002();
		Double inssFx03 = tabInss.getValorfaixa003();
		Double inssFx04 = tabInss.getValorfaixa004();
		Double inssFx05 = tabInss.getValorfaixa005();
		Double inssTeto = tabInss.getValorfaixa006();
		Double inssPerc01 = tabInss.getValorfaixa021();
		Double inssPerc02 = tabInss.getValorfaixa022();
		Double inssPerc03 = tabInss.getValorfaixa023();

		TabelaEncargos tabIrrf = tabelaEncRepos.findIrrfById(id);
		Double irrfFx01 = tabIrrf.getValorfaixa001();
		Double irrfFx02 = tabIrrf.getValorfaixa002();
		Double irrfFx03 = tabIrrf.getValorfaixa003();
		Double irrfFx04 = tabIrrf.getValorfaixa004();
		Double irrfFx05 = tabIrrf.getValorfaixa005();
		Double irrfFx06 = tabIrrf.getValorfaixa006();
		Double irrfFx07 = tabIrrf.getValorfaixa007();
		Double irrfFx08Deducao = tabIrrf.getValorfaixa008();
		Double irrfFx09Deducao = tabIrrf.getValorfaixa009();
		Double irrfFx10Deducao = tabIrrf.getValorfaixa010();
		Double irrfFx11Deducao = tabIrrf.getValorfaixa011();
		Double irrfFx12Dependente = tabIrrf.getValorfaixa012();
		Double irrfFx13Minimo = tabIrrf.getValorfaixa013();
		Double irrfFx21Perc = tabIrrf.getValorfaixa021();
		Double irrfFx22Perc = tabIrrf.getValorfaixa022();
		Double irrfFx23Perc = tabIrrf.getValorfaixa023();
		Double irrfFx24Perc = tabIrrf.getValorfaixa024();

		TabelaEncargos tabSalFam = tabelaEncRepos.findSalfamiliaById(id);
		Double salfamFx01 = tabSalFam.getValorfaixa001();
		Double salfamFx02 = tabSalFam.getValorfaixa002();
		Double salfamFx03 = tabSalFam.getValorfaixa003();
		Double salfamFx04 = tabSalFam.getValorfaixa004();
		Double salfamFx05 = tabSalFam.getValorfaixa005();

		TabelaEncargos tabIndicesGerias = tabelaEncRepos.findIndicesGeraisById(id);
		Double indicesGeraisFx01 = tabIndicesGerias.getValorfaixa001();// Horas Extra a 50%
		Double indicesGeraisFx05 = tabIndicesGerias.getValorfaixa005();// Horas Extra a 100%
		Double indicesGeraisFx06 = tabIndicesGerias.getValorfaixa006();// Dias Úteis DSR (26)
		Double indicesGeraisFx07 = tabIndicesGerias.getValorfaixa007();// Dias Inúteis DSR (5)

		// #####Variáveis de Cálculos Globais#####
		Double diasMes = 30.00;
		Double valorCem = 100.00;
		Double valorZero = 0.00;
		Double ricciSalario = pessoaAlterar.getSalario();

		Double horasBaseMensal = pessoaAlterar.getHorasBase();
		BigDecimal horasBaseValor1 = new BigDecimal(horasBaseMensal).setScale(2, RoundingMode.HALF_UP);
		horasBaseMensal = horasBaseValor1.doubleValue();

		// #####Calcular Salário Hora e arredondar com 02 decimais (Math.round)#####
		Double doublericciSalHora = Math.round((ricciSalario / horasBaseMensal) * 100.0) / 100.0;

		// #####Calcular Salário Dia#####
		Double doublericciSalDia = Math.round((ricciSalario / diasMes) * 100.0) / 100.0;
		// Double ricciSalDia = ricciSalario / diasMes;
		// Converte para String e arredonda com 02 decimais
		// String strricciSalDia = (String.format("%.2f", ricciSalDia).replace(",",
		// "."));
		// Converte String para Double
		// Double doublericciSalDia = (Double.valueOf(strricciSalDia));

		// #####Calcular Salário a Pagar em Horas ou Dias#####
		Double diasTrabalhados = pessoaAlterar.getDiasTrabalahados();

		Double horasTrabalhados = pessoaAlterar.getHorasTrabalahadas();
		BigDecimal horasTrabalhadasValor1 = new BigDecimal(horasTrabalhados).setScale(2, RoundingMode.HALF_UP);
		horasTrabalhados = horasTrabalhadasValor1.doubleValue();

		Double salarioPagarFinal = 0.00;
		Double salarioPagarHoras = 0.00;
		Double salarioPagarDias = 0.00;
		Double salarioPagarPrevio = 0.00;

		// #####Dias Trabalhados####
		if (diasTrabalhados == 30.0) {
			salarioPagarDias = ricciSalario;
			// System.out.println("DIAS TRABALHADOS Primeiro If: " + salarioPagarDias);
		} else if (diasTrabalhados != 30.0 && diasTrabalhados > 0.0) {
			salarioPagarPrevio = doublericciSalDia * diasTrabalhados;
			BigDecimal salPagarValor1 = new BigDecimal(salarioPagarPrevio).setScale(2, RoundingMode.HALF_UP);
			salarioPagarDias = salPagarValor1.doubleValue();
			// System.out.println("DIAS TRABALHADOS Segundo if: " + salarioPagarDias);
		} else {
			salarioPagarDias = valorZero;
			// System.out.println("DIAS TRABALHADOS else: " + salarioPagarDias);
		}

		// System.out.println("HORAS TRABALHADAS: " + horasTrabalhados);
		// System.out.println("JORNADA B.D: " + horasBaseMensal);
		// #####Horas Trabalhadas####
		if (horasTrabalhados == horasBaseMensal) {
			salarioPagarHoras = ricciSalario;
			// System.out.println("HORAS TRABALHADAS Primeiro If: " + salarioPagarHoras);
		} else if (horasTrabalhados != horasBaseMensal) {
			salarioPagarPrevio = doublericciSalHora * horasTrabalhados;
			BigDecimal salPagarValorht = new BigDecimal(salarioPagarPrevio).setScale(2, RoundingMode.HALF_UP);
			salarioPagarHoras = salPagarValorht.doubleValue();
			// System.out.println("HORAS TRABALHADAS Segundo If: " + salarioPagarHoras);
		} else {
			salarioPagarHoras = valorZero;
			// System.out.println("HORAS TRABALHADAS else: " + salarioPagarHoras);
		}

		salarioPagarFinal = salarioPagarDias + salarioPagarHoras;

		// if (diasTrabalhados > 0.0 && horasTrabalhados == 0.0) {
		// salarioPagarPrevio = doublericciSalDia * diasTrabalhados;
		// BigDecimal salPagarValor1 = new BigDecimal(salarioPagarPrevio).setScale(2,
		// RoundingMode.HALF_UP);
		// salarioPagar = salPagarValor1.doubleValue();
		// } else if (horasTrabalhados > 0.0 && diasTrabalhados == 0.0) {
		// salarioPagarPrevio = doublericciSalHora * horasTrabalhados;
		// BigDecimal salPagarValor1 = new BigDecimal(salarioPagarPrevio).setScale(2,
		// RoundingMode.HALF_UP);
		// salarioPagar = salPagarValor1.doubleValue();
		// } else {
		// salarioPagar = valorZero;
		// }

		// #####Calcular Horas Extra#####
		Double qtdHorasExtra1 = pessoaAlterar.getQtdHorasExtra001();
		Double horaExtraValor1 = 0.00;
		Double horaExtra01Previo = 0.00;

		if (qtdHorasExtra1 > 0.0) {
			horaExtra01Previo = (doublericciSalHora * indicesGeraisFx01) * qtdHorasExtra1;
			BigDecimal horaExtraPagarValor1 = new BigDecimal(horaExtra01Previo).setScale(2, RoundingMode.HALF_UP);
			horaExtraValor1 = horaExtraPagarValor1.doubleValue();
		} else {
			horaExtraValor1 = valorZero;
		}

		Double qtdHorasExtra2 = pessoaAlterar.getQtdHorasExtra002();
		Double horaExtraValor2 = 0.00;
		Double horaExtra02Previo = 0.00;

		if (qtdHorasExtra2 > 0.0) {
			horaExtra02Previo = (doublericciSalHora * indicesGeraisFx05) * qtdHorasExtra2;
			BigDecimal horaExtra02PagarValor1 = new BigDecimal(horaExtra02Previo).setScale(2, RoundingMode.HALF_UP);
			horaExtraValor2 = horaExtra02PagarValor1.doubleValue();
		} else {
			horaExtraValor2 = valorZero;
		}

		// #####Calcular Valor do DSR#####
		Double valoresHorasExtraDSR = horaExtraValor1 + horaExtraValor2;
		Double valorDsr = 0.00;
		Double valorDsrPagarPrevio = 0.00;

		if (valoresHorasExtraDSR > 0.0) {
			valorDsrPagarPrevio = (valoresHorasExtraDSR / indicesGeraisFx06) * indicesGeraisFx07;
			BigDecimal valorDsrPagarValor1 = new BigDecimal(valorDsrPagarPrevio).setScale(2, RoundingMode.HALF_UP);
			valorDsr = valorDsrPagarValor1.doubleValue();
		} else {
			valorDsr = valorZero;
		}

		// #####Calcular Previdência Privada#####
		Double percPrevPrivada = pessoaAlterar.getPercPrevPrivada();
		Double valorPrevPrivada = 0.00;
		Double prevPrivadaPagarPrevio = 0.00;

		if (percPrevPrivada > 0.0) {
			prevPrivadaPagarPrevio = ricciSalario * percPrevPrivada;
			BigDecimal prevPrivadaPagarValor1 = new BigDecimal(prevPrivadaPagarPrevio).setScale(2,
					RoundingMode.HALF_UP);
			valorPrevPrivada = prevPrivadaPagarValor1.doubleValue();
		} else {
			valorPrevPrivada = valorZero;
		}

		// #####Calcular Valor Quantidade de Dias de Faltas#####
		Double qtdDiasFaltas = pessoaAlterar.getQtdDiasFaltas();
		Double valorDiasFaltas = 0.00;
		Double diasFaltasDescontarPrevio = 0.00;

		if (qtdDiasFaltas > 0.0) {
			diasFaltasDescontarPrevio = doublericciSalDia * qtdDiasFaltas;
			BigDecimal diasFaltasDescValor1 = new BigDecimal(diasFaltasDescontarPrevio).setScale(2,
					RoundingMode.HALF_UP);
			valorDiasFaltas = diasFaltasDescValor1.doubleValue();
		} else {
			valorDiasFaltas = valorZero;
		}

		// #####Calcular Valor horas de Atrasos#####
		Double qtdHorasAtrasos = pessoaAlterar.getQtdHorasAtraso();
		Double valorHorasAtrasos = 0.00;
		Double valorHorasDescontarPrevio = 0.00;

		if (qtdHorasAtrasos > 0.0) {
			valorHorasDescontarPrevio = doublericciSalHora * qtdHorasAtrasos;
			BigDecimal horasAtrasoDescValor1 = new BigDecimal(valorHorasDescontarPrevio).setScale(2,
					RoundingMode.HALF_UP);
			valorHorasAtrasos = horasAtrasoDescValor1.doubleValue();
		} else {
			valorHorasAtrasos = valorZero;
		}

		// #####Calcular Valor do INSS conforme Tabela#####
		// Double inssBase = salarioPagarFinal + horaExtraValor1 + horaExtraValor2 +
		// valorDsr - valorDiasFaltas - valorHorasAtrasos;
		Double inssBase = salarioPagarFinal + horaExtraValor1 + horaExtraValor2 + valorDsr - valorDiasFaltas
				- valorHorasAtrasos;
		BigDecimal baseInssValor1 = new BigDecimal(inssBase).setScale(2, RoundingMode.HALF_UP);
		inssBase = baseInssValor1.doubleValue();

		Double inssValor = 0.00;
		Double inssValorPrevio = 0.00;

		if (inssBase <= inssFx01) {
			inssValorPrevio = inssBase * inssPerc01;
			BigDecimal inssValor1 = new BigDecimal(inssValorPrevio).setScale(2, RoundingMode.HALF_UP);
			inssValor = inssValor1.doubleValue();
		} else if (inssBase >= inssFx02 && inssBase <= inssFx03) {
			inssValorPrevio = inssBase * inssPerc02;
			BigDecimal inssValor1 = new BigDecimal(inssValorPrevio).setScale(2, RoundingMode.HALF_UP);
			inssValor = inssValor1.doubleValue();
		} else if (inssBase >= inssFx04 && inssBase <= inssFx05) {
			inssValorPrevio = inssBase * inssPerc03;
			BigDecimal inssValor1 = new BigDecimal(inssValorPrevio).setScale(2, RoundingMode.HALF_UP);
			inssValor = inssValor1.doubleValue();
		} else {
			inssValor = inssTeto;
		}

		// #####Calcular Valor do SALÁRIO FAMÍLIA conforme Tabela#####
		Double salFamQtdDep = pessoaAlterar.getQtddepsalfam();
		Double salfamBase = ricciSalario;
		Double salfamValor = 0.00;
		Double salfamValorPrevio = 0.00;

		if (salfamBase <= salfamFx01) {
			salfamValorPrevio = salfamFx04 * salFamQtdDep;
			BigDecimal salfamValor1 = new BigDecimal(salfamValorPrevio).setScale(2, RoundingMode.HALF_UP);
			salfamValor = salfamValor1.doubleValue();
		} else if (salfamBase >= salfamFx02 && salfamBase <= salfamFx03) {
			salfamValorPrevio = salfamFx05 * salFamQtdDep;
			BigDecimal salfamValor1 = new BigDecimal(salfamValorPrevio).setScale(2, RoundingMode.HALF_UP);
			salfamValor = salfamValor1.doubleValue();
		} else {
			salfamValor = valorZero;
		}

		// #####Calcular Valor do IRRF conforme Tabela#####
		Double irrfQtdDep = pessoaAlterar.getQtddepirrf();
		Double irrfValorDependentes = Math.round((irrfQtdDep * irrfFx12Dependente) * 100.0) / 100.0;
		Double irrfBaseCalculo = Math.round((inssBase - irrfValorDependentes - inssValor - valorPrevPrivada) * 100.0)
				/ 100.0;
		Double irrfValor = 0.00;
		Double irrfValorPrevio = 0.00;

		// double val1 = 4312.186462;
		// System.out.println("Double value: "+val1);
		// BigDecimal bd = new BigDecimal(val1).setScale(2, RoundingMode.HALF_UP);
		// double val2 = bd.doubleValue();
		// System.out.println("Rounded Double value: "+val2);

		if (irrfBaseCalculo <= irrfFx01) {
			irrfValor = valorZero;
		} else if (irrfBaseCalculo >= irrfFx02 && irrfBaseCalculo <= irrfFx03) {
			irrfValorPrevio = (irrfBaseCalculo * irrfFx21Perc) - irrfFx08Deducao;
			BigDecimal irrfValor1 = new BigDecimal(irrfValorPrevio).setScale(2, RoundingMode.HALF_UP);
			irrfValor = irrfValor1.doubleValue();
		} else if (irrfBaseCalculo >= irrfFx04 && irrfBaseCalculo <= irrfFx05) {
			irrfValorPrevio = (irrfBaseCalculo * irrfFx22Perc) - irrfFx09Deducao;
			BigDecimal irrfValor1 = new BigDecimal(irrfValorPrevio).setScale(2, RoundingMode.HALF_UP);
			irrfValor = irrfValor1.doubleValue();
		} else if (irrfBaseCalculo >= irrfFx06 && irrfBaseCalculo <= irrfFx07) {
			irrfValorPrevio = (irrfBaseCalculo * irrfFx23Perc) - irrfFx10Deducao;
			BigDecimal irrfValor1 = new BigDecimal(irrfValorPrevio).setScale(2, RoundingMode.HALF_UP);
			irrfValor = irrfValor1.doubleValue();
		} else if (irrfBaseCalculo >= irrfFx07) {
			irrfValorPrevio = (irrfBaseCalculo * irrfFx24Perc) - irrfFx11Deducao;
			BigDecimal irrfValor1 = new BigDecimal(irrfValorPrevio).setScale(2, RoundingMode.HALF_UP);
			irrfValor = irrfValor1.doubleValue();
		}

		if (irrfValor <= irrfFx13Minimo) {
			irrfValor = valorZero;
		}

		// Grava valor calculado nos campos "alterar_contato.html" do Front-End após
		// confirmação do botão Alterar/Gravar Cálculo
		// executado pela classe UserService.java no método calculoService chamado
		// acima.
		pessoaAlterar.setSalarioHora(doublericciSalHora);
		pessoaAlterar.setSalarioDia(doublericciSalDia);
		pessoaAlterar.setInssValor(inssValor);
		pessoaAlterar.setIrrfValor(irrfValor);
		pessoaAlterar.setValorBaseIrrf(irrfBaseCalculo);
		pessoaAlterar.setValorsalfam(salfamValor);
		pessoaAlterar.setValorBaseSalFam(salfamBase);
		pessoaAlterar.setSalarioPagar(salarioPagarFinal);
		pessoaAlterar.setValorHorasExtra001(horaExtraValor1);
		pessoaAlterar.setValorHorasExtra002(horaExtraValor2);
		pessoaAlterar.setValorPrevPrivada(valorPrevPrivada);
		pessoaAlterar.setValorDiasFaltas(valorDiasFaltas);
		pessoaAlterar.setValorHorasAtraso(valorHorasAtrasos);
		pessoaAlterar.setValorDsr(valorDsr);
		pessoaAlterar.setValorBaseInss(inssBase);

		return mav;
	}

	// Método para DELETAR contato no Banco de Dados
	@RequestMapping("/delete/{id}")
	public String deleteContato(@PathVariable(name = "id") int id) {
		userService.delete(id);
		return "redirect:/api/contatos";
	}

	@GetMapping("/exportar-para-excel")
	public void exportIntoExcelFile(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy-hh:mm:ss");
		String currentDateTime = dateFormatter.format(date);
		System.out.println("Data Formato dd-MM-aaaa hh:mm:ss : " + currentDateTime);

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=RelatorioUsuario-" + currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue);

		List<User> listOfStudents = userService.getTheListStudent();
		ExcelGenerator generator = new ExcelGenerator(listOfStudents);
		generator.generateExcelFile(response);
	}

	@GetMapping("/exportar-para-pdf")
	public void generatePdfFile(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy-hh:mm:ss");
		String currentDateTime = dateFormatter.format(date);

		String headerkey = "Content-Disposition";
		String headervalue = "attachment; filename=RelatorioUsuario-" + currentDateTime + ".pdf";
		response.setHeader(headerkey, headervalue);

		List<User> listofUsuarioPdf = userService.getTheListStudent();
		PdfGenerator generator = new PdfGenerator();
		generator.generate(listofUsuarioPdf, response);

	}
	
	
	@GetMapping("/exportar-para-csv")
	  public void exportIntoCSV(HttpServletResponse response) throws IOException {
	    response.setContentType("text/csv");
		DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy-hh:mm:ss");
		String currentDateTime = dateFormatter.format(date);

		String headerkey = "Content-Disposition";
		String headervalue = "attachment; filename=RelatorioUsuario-" + currentDateTime + ".csv";
		response.setHeader(headerkey, headervalue);
		csvGenerator.writeStudentsToCsv(userService.getTheListStudent(), response.getWriter());

	  }


	@GetMapping("/enviaremail/{id}")
	public ModelAndView showEnviarEmailPage(@PathVariable(name = "id") Integer id) {
        //Quando o e-mail for enviado a página vai para o Menu Principal
		ModelAndView mav = new ModelAndView("menuprincipal.html");
		User emailEnviar = userService.get(id);
		String espaco="------>";

		if(emailEnviar.getEmailId() != null && emailEnviar.getEmailtitulo() != null && emailEnviar.getEmailmensagem() != null) {
			SimpleMailMessage mensagemEmail = new SimpleMailMessage();
			mensagemEmail.setTo(emailEnviar.getEmailId());
            mensagemEmail.setSubject(emailEnviar.getEmailtitulo());
            mensagemEmail.setText(emailEnviar.getUserName()+espaco+emailEnviar.getEmailmensagem());
            mailSender.send(mensagemEmail);	
        } else {
       System.out.println("E-mail Não enviado");
        }
		mav.addObject("emailpessoaHtml", emailEnviar);
		return mav;
	}
	

}