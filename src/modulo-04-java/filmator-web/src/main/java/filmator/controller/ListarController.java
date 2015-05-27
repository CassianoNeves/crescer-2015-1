package filmator.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.FilmeDao;
import filmator.model.Genero;
import filmator.model.Usuario;

@Controller
public class ListarController {

	@Inject
	FilmeDao filmeDao;
	
	@RequestMapping( value = "/listar", method = RequestMethod.GET )
	public String listar( HttpSession session, Model model ) {
		model.addAttribute( "todosGeneros", Genero.values() );
		model.addAttribute( "filmes", filmeDao.buscaTodosFilmesJava8() );
		return "listar";
	}
}
