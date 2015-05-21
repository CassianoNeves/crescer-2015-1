package Cuca;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReceitasEmJSON extends ReceitasDaVovo implements LivroReceitas{

	private static final int Receitas = 0;
	private List<Receita> livro = new ArrayList<>();
	String caminhoSalvar;
	ObjectMapper mapper = new ObjectMapper();
	File json;
	
	public ReceitasEmJSON( String caminhoSalvar ) throws JsonParseException, JsonMappingException, IOException {
		this.caminhoSalvar = caminhoSalvar;
		
		json = new File( caminhoSalvar );
		if( json.canRead() ){
			livro = mapper.readValue( json, List.class);
		} else{
			System.out.println( "Não pode ler !" );
		}
		
	}
	
	@Override
	public void inserir(Receita receita) {
		if( receita == null ){
			lançaExecao( "A receita está nula!");
		}
		if( receita.getNome().equals( "" ) ){
			lançaExecao( "A receita não tem nome!");
		} else{
			livro.add( receita );
			try {
				mapper.writeValue( json, livro);
			} catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Receita inserida com sucesso!");
		}
	}
	
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		
		ReceitasEmJSON receitas;
			receitas = new ReceitasEmJSON( "/home/cassiano/Documentos/receitas.json" );
			
			Receita receita1 = new Receita( "bolo" );
			Receita receita2 = new Receita( "macarra" );
			
			
			receitas.inserir( receita1 );
			receitas.inserir( receita2 );

	}
}
