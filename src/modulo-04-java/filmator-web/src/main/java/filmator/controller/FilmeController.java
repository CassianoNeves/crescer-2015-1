package filmator.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import filmator.dao.AvaliacaoDao;
import filmator.dao.FilmeDao;
import filmator.model.Filme;
import filmator.model.Genero;
import filmator.model.Usuario;

@Controller
public class FilmeController {
	
	@Inject 
	FilmeDao filmeDao;
	
	@Inject
	AvaliacaoDao avaliacaoDao;
	
	@RequestMapping( value = "/filme/cadastro", method = RequestMethod.GET )
	public String filmeCadastro( Model model ) {
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
	public String filmeListar( HttpSession session, Model model ) {
		model.addAttribute( "filmes", filmeDao.buscaTodosFilmes() );
		return "FilmeListar";
	}
	
	@RequestMapping( value = "/naoLogado", method = RequestMethod.GET )
	public String naoLogado( Model model ) {
	
		return "naoLogado";
	}
	
	@RequestMapping( value = "/filme/home", method = RequestMethod.GET )
	public String filmeHome( Model model ) {
		model.addAttribute( "filmes", filmeDao.buscaTodosFilmes() );
		return "home";
	}
	
	@RequestMapping( value = "/filme/perfil", method = RequestMethod.GET )
	public String filmePerfil( HttpSession session, Model model, @RequestParam int idFilme ) {
		model.addAttribute( "filme", filmeDao.buscarFilme( idFilme ) );
		Usuario usuario = (Usuario) session.getAttribute( "usuarioLogado" );
		model.addAttribute( "avaliacaoPessoal", avaliacaoDao.buscarAvaliacaoPessoal( idFilme, usuario.getIdUsuario()));
		return "perfil";
	}
	
	@ResponseBody
	@RequestMapping( value = "/filme/buscarPeloNome", method = RequestMethod.GET )
	public int buscarFilmePeloNome( @RequestParam String nome ) {
		return filmeDao.buscarFilmePeloNome( nome );
	}
	
	@ResponseBody
	@RequestMapping( value = "/filme/buscarJSON", method = RequestMethod.GET )
	public List<Filme> buscarFilmes() {
		return filmeDao.buscaTodosFilmes();
	}
	
}

