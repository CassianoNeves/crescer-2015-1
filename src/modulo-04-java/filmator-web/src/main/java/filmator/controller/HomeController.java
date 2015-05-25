package filmator.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import filmator.dao.FilmeDao;
import filmator.model.Filme;
import filmator.model.Genero;

@Controller
public class HomeController {
	
	@Inject 
	FilmeDao filmeDao;
	
	@RequestMapping( value = "/", method = RequestMethod.GET )
	public String home( Model model ) {
		model.addAttribute( "todosGeneros", Genero.values() );
		return "cadastro";
	}
	
	@RequestMapping( value = "/listar", method = RequestMethod.GET )
	public String listar( Model model ) {
		model.addAttribute( "filmes", filmeDao.buscaTodosFilmesJava8() );
		return "listar";
	}
	
//	@ResponseBody
	@RequestMapping(value = "/inserir", method = RequestMethod.POST)
	public String inserir(Model model, Filme filme) {
		
		try {
			filmeDao.inserir(filme);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errooou");
		}
		
		return "redirect:/listar";
	}
	
	@RequestMapping(value = "/excluir", method = RequestMethod.GET)
	public String excluir( Model model, @RequestParam int idFilme ){
		filmeDao.excluir( idFilme );
		return "redirect:/listar";
	}
	
	
}

