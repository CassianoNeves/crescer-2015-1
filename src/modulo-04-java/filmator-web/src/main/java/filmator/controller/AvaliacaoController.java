package filmator.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import filmator.dao.AvaliacaoDao;
import filmator.model.Avaliacao;
import filmator.model.Usuario;

@Controller
public class AvaliacaoController {
	
	@Inject
	AvaliacaoDao avaliacaoDao;
	
	@ResponseBody
	@RequestMapping( value = "/filme/avaliar", method = RequestMethod.POST )
	public String inserir( HttpSession session, @RequestParam int nota, @RequestParam int idFilme ){
		Usuario usuario = (Usuario) session.getAttribute( "usuarioLogado" );
		Avaliacao avaliacao = new Avaliacao( usuario.getIdUsuario(), idFilme, nota );
		avaliacaoDao.inserir( avaliacao );
		return "ok";
	}
	
	@ResponseBody
	@RequestMapping( value = "/filme/atualizarMedia", method = RequestMethod.GET )
	public int buscarNotaMedia( Model model, @RequestParam int idFilme ){
		int notaMedia = avaliacaoDao.buscarNotaMediaPorFilme( idFilme );
		String media = "NotaMedia: " + notaMedia;
		return notaMedia;
	}

}
