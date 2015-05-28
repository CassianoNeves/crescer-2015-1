package filmator.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import filmator.model.Usuario;

@Component
public class UsuarioDao {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public boolean existeUsuario( Usuario usuario ){
		
		List<Usuario> usuarios = jdbcTemplate.query( "SELECT NOME, SENHA FROM USUARIO WHERE NOME = ? AND SENHA = ?",
				(ResultSet rs, int rowNum) -> {
					Usuario usuarioRetorno = new Usuario( rs.getString( "nOme" ), rs.getString( "senha" ) );
					return usuarioRetorno;
				},
				usuario.getNome(),
				usuario.getSenha() );
		
		if( usuarios.size() == 1 ){
			return true;
		}
		
		return false;
		
	}
	
	public void inserirUsuario( Usuario usuario ){
		jdbcTemplate.update( "INSERT INTO (NOME, " +
				"EMAIL, " +
				"SENHA) " +
				"VALUES (?, ?, ?)",
				usuario.getNome(),
				usuario.getEmail(),
				usuario.getSenha());
	}
	
	
	
	
	
}
