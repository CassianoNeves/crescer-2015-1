package filmator.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
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

}
