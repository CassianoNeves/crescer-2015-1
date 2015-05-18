package Cuca;

import java.util.List;

public interface LivroReceitas {
	
	void inserir( Receita receita);
	void atualizar( String nome, Receita ReceitaAtualizada );
	void excluir( String nome );
	List<Receita> getTodasReceitas();
	Receita buscaReceitaPeloNome( String nome );
	
}
