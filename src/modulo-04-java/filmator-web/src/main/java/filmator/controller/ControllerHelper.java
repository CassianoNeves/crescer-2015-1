package filmator.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import filmator.model.Usuario;

@ControllerAdvice
public class ControllerHelper {
	
	@ModelAttribute("usuarioLogado")
	public Usuario usuarioLogado(HttpSession session ){
		return (Usuario) session.getAttribute("usuarioLogado");
	}
}
