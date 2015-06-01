package filmator.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import filmator.model.Avaliacao;

@Component
public class AvaliacaoDao {
	
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public void inserir( Avaliacao avaliacao ){
		
		List<Avaliacao> avaliacoes =  buscarAvaliacao( avaliacao );
		
		if( avaliacoes.size() == 0 ) {
			jdbcTemplate.update( "INSERT INTO AVALIACAO (IDFILME, IDUSUARIO, NOTA) VALUES (?, ?, ?)",
					avaliacao.getIdFilme(),
					avaliacao.getIdUsuario(),
					avaliacao.getNota() );
		} else {
			jdbcTemplate.update( "UPDATE AVALIACAO SET NOTA = ? WHERE IDFILME = ? AND IDUSUARIO = ?",
					avaliacao.getNota(),
					avaliacao.getIdFilme(),
					avaliacao.getIdUsuario());
		}
	}
	
	public List<Avaliacao> buscarAvaliacao( Avaliacao avaliacao ){
		
		List<Avaliacao> avaliacoes =  jdbcTemplate.query( "SELECT * "
				+ "FROM AVALIACAO "
				+ "WHERE IDFILME = ? "
				+ "AND IDUSUARIO = ?", (ResultSet rs, int rowNum) ->{
			
			Avaliacao avaliacaoResultado = new Avaliacao(rs.getInt( "idUsuario"), rs.getInt( "idFilme" ), rs.getInt( "nota" ));
			avaliacaoResultado.setIdAvaliacao( rs.getInt( "idAvaliacao" ) );
			return avaliacaoResultado;
		}, 
		avaliacao.getIdFilme(),
		avaliacao.getIdUsuario());
		
		return avaliacoes;
	}
	
	public Avaliacao buscarAvaliacaoPessoal( int idFilme, int idUsuario ){
		List<Avaliacao> avaliacoes = jdbcTemplate.query( "select * from AVALIACAO where idfilme = ? and idUsuario = ?", 
				(ResultSet rs, int rowNum) ->{
					Avaliacao avaliacao = new Avaliacao(rs.getInt( "idUsuario"), rs.getInt( "idFilme" ), rs.getInt( "nota" ));
				return avaliacao;
		}
		,idFilme, idUsuario );
		
		if( avaliacoes.size() == 1 ){
			return avaliacoes.get( 0 );
		}
		
		return new Avaliacao(idUsuario, idFilme, 0);
	}
	
	public int buscarNotaMediaPorFilme( int idFilme ){
		List<Integer> medias = jdbcTemplate.query( "SELECT AVG(NOTA) AS MEDIA FROM AVALIACAO WHERE IDFILME = ? ", 
				(ResultSet rs, int rowNum) ->{
			return rs.getInt( "media" );
		}, idFilme);
		
		return medias.get( 0 );
	}
}
