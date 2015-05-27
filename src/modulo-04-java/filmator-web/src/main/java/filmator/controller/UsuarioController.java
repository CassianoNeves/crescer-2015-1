package filmator.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import filmator.dao.UsuarioDao;
import filmator.model.Usuario;

@Controller
public class UsuarioController {
	
	@Inject 
	UsuarioDao usuarioDao;
	
	@RequestMapping( value = "/login", method = RequestMethod.GET )
	public String login(  Model model, @RequestParam(defaultValue="false") boolean error ) {
			if( error ){
				model.addAttribute( "erro", "Usuário ou Senha inválidos." );
			}
			
			return "login";
	}
	
	@RequestMapping(value = "/validarUsuario", method = RequestMethod.POST)
	public String validaUsuario(Model model, HttpSession session, Usuario usuario ){
		if( usuarioDao.existeUsuario( usuario ) ){
			session.setAttribute( "usuarioLogado" , usuario );
			return "redirect:/cadastro";
		}
		
		return "redirect:/login?error=true";
	}
}
