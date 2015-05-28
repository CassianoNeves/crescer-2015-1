package filmator.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import filmator.dao.FilmeDao;
import filmator.model.Filme;
import filmator.model.Genero;

@Controller
public class FilmeController {
	
	@Inject 
	FilmeDao filmeDao;
	
	@RequestMapping( value = "/filme/cadastro", method = RequestMethod.GET )
	public String filmeCadastro( HttpSession session, Model model ) {
		model.addAttribute( "todosGeneros", Genero.values() );
		return "FilmeCadastro";
	}
	
//	@ResponseBody
	@RequestMapping(value = "/filme/inserir", method = RequestMethod.POST)
	public String filmeInserir(Model model, Filme filme) {
		try {
			filmeDao.inserir(filme);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errooou");
		}
		
		return "redirect:/filme/listar";
	}
	
	@RequestMapping(value = "/filme/excluir", method = RequestMethod.GET)
	public String filmeExcluir( Model model, @RequestParam int idFilme ){
		filmeDao.excluir( idFilme );
		return "redirect:/filme/listar";
	}
	
	@RequestMapping( value = "/filme/listar", method = RequestMethod.GET )
	public String listar( HttpSession session, Model model ) {
		model.addAttribute( "todosGeneros", Genero.values() );
		model.addAttribute( "filmes", filmeDao.buscaTodosFilmesJava8() );
		return "FilmeListar";
	}
}

