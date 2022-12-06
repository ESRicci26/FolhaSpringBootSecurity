package com.javaricci.FolhaSpringBootSecurity.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.javaricci.FolhaSpringBootSecurity.Entity.UserUsuario;
import com.javaricci.FolhaSpringBootSecurity.Service.UserUsuarioService;

@Controller
public class UserUsuarioController {

	@Autowired
	private UserUsuarioService userUsuarioServ;
	
	// Lista todos Usuários Banco de Dados na página principal usuarios_lista.html
	@RequestMapping("/jesus")
	//@GetMapping("/usuariosricci")
	public String viewHomePage(Model model) {
		List<UserUsuario> listPessoas = userUsuarioServ.listAll();
		model.addAttribute("listUsuariosHtml", listPessoas);

		return "usuarios_lista.html";
	}


	// Método para INCLUIR Usuários no Banco de Dados
	@RequestMapping("/inclusao")
	public String salvarUsuarios(Model model) {
		UserUsuario userTeste = new UserUsuario();
		model.addAttribute("incluirusuarioHtml", userTeste);
		return "usuarios_novo";
	}


	// Método para Salvar/Alterar Usuários no Banco de Dados com senha criptografada
	// BCryptPasswordEncoder 
	@RequestMapping(value = "/savefrontricci", method = RequestMethod.POST)
	public String salvarUserRicci(@ModelAttribute("pessoa") UserUsuario userContato) {
		userUsuarioServ.salvarUsuario(userContato);

		return "redirect:/jesus";

	}


	// Método para ALTERAR Usuários no Banco de Dados
	@RequestMapping("/edituser/{id}")
	public ModelAndView showUpdateUserPageRicci(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("usuarios_alterar");
		UserUsuario usuarioAlterar = userUsuarioServ.get(id);
		mav.addObject("usuariosHtml", usuarioAlterar);

		return mav;
	}


	// Método para DELETAR Usuários no Banco de Dados
	@RequestMapping("/deleteuser/{id}")
	public String deleteUserRicci(@PathVariable(name = "id") long id) {
		userUsuarioServ.delete(id);

		return "redirect:/jesus";
	}
	
}
