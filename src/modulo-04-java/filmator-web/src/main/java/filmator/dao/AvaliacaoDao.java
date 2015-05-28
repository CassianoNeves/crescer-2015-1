package filmator.dao;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import filmator.model.Avaliacao;

@Component
public class AvaliacaoDao {
	
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public void inserir( Avaliacao avaliacao ){
		jdbcTemplate.update( "INSERT INTO AVALIACAO (IDFILME, IDUSUARIO, NOTA) VALUES (?, ?, ?)",
				avaliacao.getIdFilme(),
				avaliacao.getIdUsuario(),
				avaliacao.getNota() );
	}

}
