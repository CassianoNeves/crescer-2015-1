package filmator.dao;

import java.sql.ResultSet;
import java.util.List;




import javax.inject.Inject;




import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;




import filmator.model.Filme;import filmator.model.Genero;import filmator.model.Usuario;



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
	
	public List<Filme> buscaTodosFilmes(){
		return jdbcTemplate.query("SELECT f.idfilme, f.nome, f.genero, f.ano, f.sinopse, f.imagem, avg(a.nota) as mediaNota "
					+ "FROM filme f LEFT JOIN avaliacao a "
					+ "ON f.idfilme = a.idfilme "
					+ "WHERE situacao = 'A'"
					+ "GROUP BY f.idfilme, f.nome, f.genero, f.ano, f.sinopse, f.imagem", (ResultSet rs, int rowNum) -> {
					Genero genero = Genero.valueOf(rs.getString("genero"));
					Filme filme = new Filme(rs.getString( "nome" ),
					genero, 
					rs.getInt( "ano" ),
					rs.getString( "sinopse" ),
					rs.getString( "imagem" ),
					rs.getInt( "mediaNota"));
					filme.setIdFilme( rs.getInt( "idFilme" ));
			
			return filme;
		});	
	}
	
	public Filme buscarFilme( int idFilme ){
		List<Filme> filmes = jdbcTemplate.query( "SELECT f.idfilme, f.nome, f.genero, f.ano, f.sinopse, f.imagem, avg(a.nota) as mediaNota "
					+ "FROM filme f LEFT JOIN avaliacao a "
					+ "ON f.idfilme = a.idfilme "
					+ "WHERE f.idFilme = ?"
					+ "GROUP BY f.idfilme, f.nome, f.genero, f.ano, f.sinopse, f.imagem", (ResultSet rs, int rowNum) ->{
			Genero genero = Genero.valueOf(rs.getString("genero"));
			Filme filme = new Filme(rs.getString( "nome" ), 
					genero, rs.getInt( "ano" ), 
					rs.getString( "sinopse" ),
					rs.getString( "imagem" ), 
					rs.getInt( "mediaNota" ));
			filme.setIdFilme( rs.getInt( "idFilme" ) );
			return filme;
		}, idFilme);
		
		return filmes.get(0);
	}
	
	public void excluir( int idFilme ){
		jdbcTemplate.update( "UPDATE FILME SET SITUACAO = 'I' WHERE IDFILME = ?", idFilme );
	}
	
	public int buscarFilmePeloNome( String nome ){
		
		List<Integer> filmes = jdbcTemplate.query( "SELECT * FROM FILME WHERE NOME = ?", (ResultSet rs, int rowNum) ->{
			return rs.getInt( "idFilme" );
		},
		nome);
		
		return filmes.get( 0 );
	}
}
 