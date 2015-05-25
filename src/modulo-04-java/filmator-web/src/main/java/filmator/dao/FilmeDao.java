package filmator.dao;

import java.sql.ResultSet;
import java.util.List;


import javax.inject.Inject;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


import filmator.model.Filme;import filmator.model.Genero;


@Component
public class FilmeDao {

	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public void inserir(Filme filme){
		jdbcTemplate.update("INSERT INTO Filme (nome, "
				+ "genero, "
				+ "ano, "
				+ "sinopse, "
				+ "imagem) "
				+ "VALUES (?, ?, ?, ?, ?)", 
				filme.getNome(), 
				filme.getGenero().name(), 
				filme.getAno(), 
				filme.getSinopse(), 
				filme.getImagem());
	}
	
	public List<Filme> buscaTodosFilmesJava8(){
		return jdbcTemplate.query("SELECT * FROM Filme", (ResultSet rs, int rowNum) -> {
			Genero genero = Genero.valueOf(rs.getString("genero"));
			Filme filme = new Filme(rs.getString( "nome" ),
					genero, 
					rs.getInt( "ano" ),
					rs.getString( "sinopse" ),
					rs.getString( "imagem" ));
			filme.setIdFilme( rs.getInt( "idFilme" ));
			return filme;
		});	
	}
	
	public void excluir( int idFilme ){
		jdbcTemplate.update( "DELETE from Filme where idFilme = ?", idFilme );
	}


}
 