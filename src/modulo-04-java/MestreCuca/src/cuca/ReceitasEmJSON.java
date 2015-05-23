package cuca;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ReceitasEmJSON extends ReceitasDaVovo implements LivroReceitas{

	private static final int Receitas = 0;
	private List<Receita> livro = new ArrayList<>();
	private String caminhoSalvar;
	private ObjectMapper mapper = new ObjectMapper();
	private File json;
	
	public ReceitasEmJSON( String caminhoSalvar ) {
		this.caminhoSalvar = caminhoSalvar;
		
		mapper.enable( SerializationFeature.INDENT_OUTPUT );
		
		json = new File( caminhoSalvar );
		
		if( json.canRead() ){
			carregarReceitasDoArquivoJSON();
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
			escreveReceitasEmArquivoJSON();
			System.out.println("Receita inserida com sucesso!");
		}
	}

	private void escreveReceitasEmArquivoJSON() {
		try {
			mapper.writeValue( json, livro);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private void carregarReceitasDoArquivoJSON() {
		try {
			livro = mapper.readValue( json, List.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		
		ReceitasEmJSON receitas;
		receitas = new ReceitasEmJSON( "/home/cassiano/Documentos/receitas.json" );
		
		Receita receita1 = new Receita( "bolo" );
		Receita receita2 = new Receita( "macarra" );
		
		receitas.inserir( receita1 );
		receitas.inserir( receita2 );
	}
}
