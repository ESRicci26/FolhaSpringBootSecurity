package com.javaricci.FolhaSpringBootSecurity.Controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.javaricci.FolhaSpringBootSecurity.DTO.TabelaEncargosDTO;
import com.javaricci.FolhaSpringBootSecurity.Entity.TabelaEncargos;
import com.javaricci.FolhaSpringBootSecurity.Service.TabelaEncargosService;


@Controller
@RequestMapping("/apiencargos")
public class TabelaEncargosController {

	@Autowired
	private TabelaEncargosService encargosService;

	@Autowired
	private ModelMapper modelMapper;
	
	
	//####CRIAÇÃO DA API####

	//GET Type: http://localhost:8080/apiencargos/encargos	
	@GetMapping("/encargos")
	public ResponseEntity<?> getEncargos() {

		Map<String, Object> jsonResponseMap = new LinkedHashMap<String, Object>();
		List<TabelaEncargos> listofEncargos = encargosService.getAllEncargosList();
		List<TabelaEncargosDTO> listofEncargosDto = new ArrayList<TabelaEncargosDTO>();

		if (!listofEncargos.isEmpty()) {

			for (TabelaEncargos tabEnc : listofEncargos) {
				listofEncargosDto.add(modelMapper.map(tabEnc, TabelaEncargosDTO.class));
			}

			jsonResponseMap.put("status", 1);
			jsonResponseMap.put("data", listofEncargosDto);
			return new ResponseEntity<>(jsonResponseMap, HttpStatus.OK);

		} else {

			jsonResponseMap.clear();
			jsonResponseMap.put("status", 0);
			jsonResponseMap.put("message", "Os dados não foram encontrados");
			return new ResponseEntity<>(jsonResponseMap, HttpStatus.NOT_FOUND);

		}

	}

	
	/*
    POST Type: http://localhost:8080/apiencargos/save
	{
	"userName": "Edilson",
	"mobileNo": "32656665",
	"emailId": "esricci@gmail.com",
	"city": "São Paulo/SP",
	"password": "123456"
	}
	*/
	@PostMapping("/save")
	public ResponseEntity<?> saveEncargos(@RequestBody TabelaEncargosDTO encargosDTO) {

		Map<String, Object> jsonResponseMap = new LinkedHashMap<String, Object>();
		//Converter DTO numa Entidade
		TabelaEncargos tabEnc = modelMapper.map(encargosDTO, TabelaEncargos.class);
		encargosService.save(tabEnc);
		jsonResponseMap.put("status", 1);
		jsonResponseMap.put("message", "O registro foi salvo com sucesso!");
		return new ResponseEntity<>(jsonResponseMap, HttpStatus.CREATED);
	}

	
	//GET Type: http://localhost:8080/apiencargos/encargosid/1
	@GetMapping("/encargosid/{id}")
	public ResponseEntity<?> getEncargosById(@PathVariable Integer id) {
		Map<String, Object> jsonResponseMap = new LinkedHashMap<String, Object>();
		try {

			TabelaEncargos tabEnc = encargosService.findById(id);
			// Converter Entity em DTO
			TabelaEncargosDTO encargosDTO = modelMapper.map(tabEnc, TabelaEncargosDTO.class);
			jsonResponseMap.put("status", 1);
			jsonResponseMap.put("data", encargosDTO);
			return new ResponseEntity<>(jsonResponseMap, HttpStatus.OK);

		} catch (Exception ex) {

			jsonResponseMap.clear();
			jsonResponseMap.put("status", 0);
			jsonResponseMap.put("message", "Os dados não foram encontrados");
			return new ResponseEntity<>(jsonResponseMap, HttpStatus.NOT_FOUND);

		}

	}

	
	//DELETE Type: http://localhost:8080/apiencargos/delete/1
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEncargos(@PathVariable Integer id) {
		Map<String, Object> jsonResponseMap = new LinkedHashMap<String, Object>();
		try {
			TabelaEncargos tabenc = encargosService.findById(id);
			encargosService.delete(tabenc);
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
    PUT Type: http://localhost:8080/apiencargos/update/1
	{
	"userName": "Salvador",
	"mobileNo": "30184611",
	"emailId": "esricci26@gmail.com",
	"city": "Paraná/PR",
	"password": "789"
	}
	*/
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateEncargos(@PathVariable Integer id, @RequestBody TabelaEncargosDTO encargosDTO) {
		Map<String, Object> jsonResponseMap = new LinkedHashMap<String, Object>();
		try {

			TabelaEncargos tabenc = encargosService.findById(id);
			tabenc.setDataInicio(encargosDTO.getDataInicio());
			tabenc.setDataFim(encargosDTO.getDataFim());
			tabenc.setSituacao(encargosDTO.getSituacao());
			tabenc.setNomeTabela(encargosDTO.getNomeTabela());
			tabenc.setValorfaixa001(encargosDTO.getValorfaixa001());
			tabenc.setValorfaixa002(encargosDTO.getValorfaixa002());
			tabenc.setValorfaixa003(encargosDTO.getValorfaixa003());
			tabenc.setValorfaixa004(encargosDTO.getValorfaixa004());
			tabenc.setValorfaixa005(encargosDTO.getValorfaixa005());
			tabenc.setValorfaixa006(encargosDTO.getValorfaixa006());
			tabenc.setValorfaixa007(encargosDTO.getValorfaixa007());
			tabenc.setValorfaixa008(encargosDTO.getValorfaixa008());
			tabenc.setValorfaixa009(encargosDTO.getValorfaixa009());
			tabenc.setValorfaixa010(encargosDTO.getValorfaixa010());
			tabenc.setValorfaixa011(encargosDTO.getValorfaixa011());
			tabenc.setValorfaixa012(encargosDTO.getValorfaixa012());
			tabenc.setValorfaixa013(encargosDTO.getValorfaixa013());
			tabenc.setValorfaixa014(encargosDTO.getValorfaixa014());
			tabenc.setValorfaixa015(encargosDTO.getValorfaixa015());
			tabenc.setValorfaixa016(encargosDTO.getValorfaixa016());
			tabenc.setValorfaixa017(encargosDTO.getValorfaixa017());
			tabenc.setValorfaixa018(encargosDTO.getValorfaixa018());
			tabenc.setValorfaixa019(encargosDTO.getValorfaixa019());
			tabenc.setValorfaixa020(encargosDTO.getValorfaixa020());
			tabenc.setValorfaixa021(encargosDTO.getValorfaixa021());
			tabenc.setValorfaixa022(encargosDTO.getValorfaixa022());
			tabenc.setValorfaixa023(encargosDTO.getValorfaixa023());
			tabenc.setValorfaixa024(encargosDTO.getValorfaixa024());
			tabenc.setValorfaixa025(encargosDTO.getValorfaixa025());
			tabenc.setValorfaixa026(encargosDTO.getValorfaixa026());
			tabenc.setValorfaixa027(encargosDTO.getValorfaixa027());
			tabenc.setValorfaixa028(encargosDTO.getValorfaixa028());
			tabenc.setValorfaixa029(encargosDTO.getValorfaixa029());
			tabenc.setValorfaixa030(encargosDTO.getValorfaixa030());
			
			encargosService.save(tabenc);

			jsonResponseMap.put("status", 1);
			jsonResponseMap.put("data", encargosService.findById(id));
			return new ResponseEntity<>(jsonResponseMap, HttpStatus.OK);

		} catch (Exception ex) {

			jsonResponseMap.clear();
			jsonResponseMap.put("status", 0);
			jsonResponseMap.put("message", "Os dados não foram encontrados");
			return new ResponseEntity<>(jsonResponseMap, HttpStatus.NOT_FOUND);

		}

	}
	
	
	
	//####CRIAÇÃO DO FRONT-END USANDO THYMELEAF####
	//http://localhost:8080/apiencargos/encargosprincipal
	
	//Lista todos Contatos Banco de Dados na página principal index.html
	@GetMapping("/encargosprincipal")
	public String viewHomePageEncargos(Model model, String keyword) {
		if(keyword == null){
			List<TabelaEncargos> listEncSoc = encargosService.getAllEncargosList();
			model.addAttribute("listEncSocHtml", listEncSoc);
			}else{
				List<TabelaEncargos> listEncSocFiltro = encargosService.findByKeyword(keyword);
				model.addAttribute("listEncSocHtml", listEncSocFiltro);
			}
		return "ricciencargos_index.html";
	}
	
	
	/* MÉTODO ANTERIOR SEM USAR SEARCH (BUSCA)
	@GetMapping("/encargosprincipal")
	public String viewHomePageEncargos(Model model) {
		List<TabelaEncargos> listEncSoc = encargosService.getAllEncargosList();
		model.addAttribute("listEncSocHtml", listEncSoc);
		return "ricciencargos_index.html";
	}
*/


	//Tela Inclusão de novo contato no Banco de Dados - Página novo_contato.html
	@GetMapping("/inclusao")
	public String showNewEncargosPage(Model model) {
		TabelaEncargos encSociais = new TabelaEncargos();
		model.addAttribute("incluirEncSociaisHtml", encSociais);
		
		return "ricciencargos_novatabela";
	}
	
	//Método para Salvar/Alterar contato no Banco de Dados
	@RequestMapping(value = "/savefront", method = RequestMethod.POST)
	public String salvarEncargos(@ModelAttribute("encargos") TabelaEncargos tabEncargos) {
		encargosService.save(tabEncargos);
		
		return "redirect:/apiencargos/encargosprincipal";

	}
	
	//Método para ALTERAR contato no Banco de Dados
	@GetMapping("/edit/{id}")
	public ModelAndView showAlterarEncargosPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("ricciencargos_alterar.html");
		TabelaEncargos encargosAlterar = encargosService.get(id);
		mav.addObject("encargosHtml", encargosAlterar);
		
		return mav;
	}
	
	//Método para DELETAR contato no Banco de Dados
	@RequestMapping("/delete/{id}")
	public String deleteEncargos(@PathVariable(name = "id") int id) {
		encargosService.delete(id);
		return "redirect:/apiencargos/encargosprincipal";		
	}
	
	

	

}