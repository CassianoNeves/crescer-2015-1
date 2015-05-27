package filmator.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import filmator.dao.FilmeDao;
import filmator.dao.UsuarioDao;
import filmator.model.Filme;
import filmator.model.Genero;
import filmator.model.Usuario;

@Controller
public class HomeController {
	
	@Inject 
	FilmeDao filmeDao;
	
	@RequestMapping( value = "/cadastro", method = RequestMethod.GET )
	public String home( HttpSession session, Model model ) {
		
		
		Usuario usuarioLogado = (Usuario) session.getAttribute( "usuarioLogado");
		model.addAttribute( "todosGeneros", Genero.values() );
		model.addAttribute( "nomeUsuario", usuarioLogado.getNome() );
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

